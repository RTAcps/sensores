package com.rtacps.sensores.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rtacps.sensores.dto.SensorDTO;
import com.rtacps.sensores.entities.Sensor;
import com.rtacps.sensores.exceptions.BadRequestException;
import com.rtacps.sensores.exceptions.InsertException;
import com.rtacps.sensores.exceptions.NotFoundException;
import com.rtacps.sensores.repositories.SensorRepository;

@Service
public class SensorService {

	@Autowired
	private SensorRepository repository;

	public Page<SensorDTO> findSensor(Pageable pageable) {		
		Page<Sensor> sensors = repository.findAll(pageable);

		return sensors.map(sensor -> new SensorDTO(sensor));			
	}

	public Sensor findById(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Sensor não encontrada com o ID: " + id));		
	}
	
	public Sensor insert(@RequestBody Sensor sensor) {
	    Sensor result = repository.save(sensor);
	    try {
		    if (result == null) {
		        throw new InsertException("Erro ao inserir o sensor no banco de dados.");
		    }
		    return result;
	    } catch(Exception ex) {
	    	throw new BadRequestException("Dados inválidos na solicitação.");
	    }
	}
	
	public Sensor update(@RequestBody Sensor sensor) {
	    Sensor result = repository.save(sensor);
	    try {
		    if (result == null) {
		        throw new InsertException("Erro ao inserir a sensor no banco de dados.");
		    }
		    return result;
	    } catch(Exception ex) {
	    	throw new BadRequestException("Dados inválidos na solicitação.");
	    }
	}

	public class ExceptionHandlerController {
		@ExceptionHandler(BadRequestException.class)
		public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}

		@ExceptionHandler(NotFoundException.class)
		public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}

		@ExceptionHandler(InsertException.class)
		public ResponseEntity<String> handleInsertException(InsertException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
