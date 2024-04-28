package com.rtacps.sensores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rtacps.sensores.entities.Sensor;
import com.rtacps.sensores.exceptions.BadRequestException;
import com.rtacps.sensores.exceptions.InsertException;
import com.rtacps.sensores.exceptions.NotFoundException;
import com.rtacps.sensores.services.SensorService;

@RestController
@RequestMapping(value = "/sensores")
public class SensorController {

	@Autowired
	private SensorService service;

	public void setSensorService(SensorService service) {
		this.service = service;
	}

	@GetMapping
	public Page<Sensor> findSensor(Pageable pageable) {
		Page<Sensor> result = service.findSensor(pageable);
		return result;
	}

	@GetMapping(value = "/{id}")
	public Sensor findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Sensor insert(@RequestBody Sensor sensor) {
	    return service.insert(sensor);	    
	}
	

	@PutMapping
	public Sensor update(@RequestBody Sensor sensor) {
	    return service.update(sensor);	    
	}

	@RestControllerAdvice
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
