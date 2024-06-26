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

import com.rtacps.sensores.dto.MachineDTO;
import com.rtacps.sensores.entities.Machine;
import com.rtacps.sensores.services.MachineService;

@RestController
@RequestMapping(value = "/api/v1/machines")
public class MachineController {
	
	@Autowired
	private MachineService service;
	
	public void setMachineService(MachineService service){
        this.service = service;
    }
	
	@GetMapping
	public ResponseEntity<Page<MachineDTO>> findMachine(Pageable pageable) {
	  Page<MachineDTO> result = service.findMachine(pageable);
	  return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{id}")
	public Machine findById(@PathVariable Long id) {
		return service.findById(id);		
	}
	
	@PostMapping
	public Machine insert(@RequestBody Machine machine) {
	    return service.insert(machine);	    
	}
	

	@PutMapping
	public Machine update(@RequestBody Machine machine) {
	    return service.update(machine);	    
	}
		
}
