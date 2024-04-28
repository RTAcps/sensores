package com.rtacps.sensores.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.rtacps.sensores.entities.Machine;
import com.rtacps.sensores.entities.Sensor;
import com.rtacps.sensores.repositories.MachineRepository;
import com.rtacps.sensores.repositories.SensorRepository;

public class CsvImportService {

	private MachineRepository machineRepository;
	private SensorRepository sensorRepository;

	public void importCsvData(MultipartFile file) throws IOException {
		try {
			CSVParserBuilder parserBuilder = new CSVParserBuilder();
			CSVParser parser = parserBuilder.build();

			Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();

			List<String[]> records = csvReader.readAll();

			for (String[] record : records) {
				String machineName = record[0];
				String sensorName = record[1];

				Machine machine = machineRepository.findByName(machineName);
				if (machine == null) {
					machine = new Machine();
					machine.setName(machineName);
					machineRepository.save(machine);
				}

				Sensor sensor = new Sensor();
				sensor.setName(sensorName);
				sensor.setMachine(machine);
				sensorRepository.save(sensor);
			}
		} catch (CsvException e) {
			// Handle the exception: log the error, provide informative message to user
			e.printStackTrace(); // For debugging purposes
			throw new RuntimeException("Error parsing CSV data: " + e.getMessage()); // Or customize error message
		}
	}
}
