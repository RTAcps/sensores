package com.rtacps.sensores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtacps.sensores.dto.SensorDTO;
import com.rtacps.sensores.entities.Sensor;
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
	public ResponseEntity<Page<SensorDTO>> findSensor(Pageable pageable) {
		  Page<SensorDTO> result = service.findSensor(pageable);
		  return ResponseEntity.ok(result);
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

}
