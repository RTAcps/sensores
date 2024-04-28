package com.rtacps.sensores.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.rtacps.sensores.entities.Leitura;
import com.rtacps.sensores.entities.Machine;
import com.rtacps.sensores.entities.Sensor;
import com.rtacps.sensores.repositories.LeitorRepository;
import com.rtacps.sensores.repositories.SensorRepository;
import com.rtacps.sensores.services.MachineService;

public class SensorProcessor implements Runnable {

	private MachineService machineService = new MachineService();
	private SensorRepository sensorRepository = null;

	public void SensorDataProcessor(MachineService machineService, SensorRepository sensorRepository) {
		this.machineService = machineService;
		this.sensorRepository = sensorRepository;
	}

	@Override
	public void run() {
		List<Machine> machines = machineService.fetchAllMachine();

		for (Machine machine : machines) {
			List<Sensor> sensors = machine.getSensors();

			for (Sensor sensor : sensors) {
				sensorRepository.save(sensor);
			}
		}
	}

	@Scheduled(fixedRate = 300)
	public void processSensorData(@Autowired LeitorRepository leituraRepository) {
		List<Machine> machines = machineService.fetchAllMachine();
		for (Machine machine : machines) {
			List<Sensor> sensors = machine.getSensors();

			for (Sensor sensor : sensors) {
				List<Leitura> leituras = sensor.getLeituras();
				
				for (Leitura leitura : leituras) {
					   leituraRepository.save(leitura);
					}
			}
		}
	}

}