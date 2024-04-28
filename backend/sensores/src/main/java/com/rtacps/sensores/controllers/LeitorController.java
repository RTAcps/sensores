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

import com.rtacps.sensores.dto.LeituraDTO;
import com.rtacps.sensores.entities.Leitura;
import com.rtacps.sensores.services.LeitorService;

@RestController
@RequestMapping(value = "/leitura")
public class LeitorController {

	@Autowired
	private LeitorService service;
	
	public void setLeitorService(LeitorService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Page<LeituraDTO>> findSensor(Pageable pageable) {
		  Page<LeituraDTO> result = service.findLeitura(pageable);
		  return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{id}")
	public Leitura findById(@PathVariable Long id) {
		return service.findById(id);
	}


	@PostMapping
	public Leitura insert(@RequestBody Leitura leitura) {
	    return service.insert(leitura);	    
	}
	

	@PutMapping
	public Leitura update(@RequestBody Leitura leitura) {
	    return service.update(leitura);	    
	}
	
}
