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
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rtacps.sensores.entities.Machine;
import com.rtacps.sensores.exceptions.BadRequestException;
import com.rtacps.sensores.exceptions.InsertException;
import com.rtacps.sensores.exceptions.NotFoundException;
import com.rtacps.sensores.repositories.MachineRepository;

@Service
public class MachineService {

	@Autowired
	private MachineRepository repository;

	public Page<Machine> findMachine(Pageable pageable) {		
		return repository.findAll(pageable);			
	}

	public Machine findById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Máquina não encontrada com o ID: " + id));
	}
	
	public Machine insert(@RequestBody Machine machine) {
	    Machine result = repository.save(machine);
	    try {
		    if (result == null) {
		        throw new InsertException("Erro ao inserir a máquina no banco de dados.");
		    }
		    return result;
	    } catch(Exception ex) {
	    	throw new BadRequestException("Dados inválidos na solicitação.");
	    }
	}
	
	public Machine update(@RequestBody Machine machine) {
	    Machine result = repository.save(machine);
	    try {
		    if (result == null) {
		        throw new InsertException("Erro ao inserir a máquina no banco de dados.");
		    }
		    return result;
	    } catch(Exception ex) {
	    	throw new BadRequestException("Dados inválidos na solicitação.");
	    }
	}
	
	@RestControllerAdvice
	public class ExceptionHandlerController {
		@ExceptionHandler(BadRequestException.class)
	    public ResponseEntity<String> handleMachineBadRequestException(BadRequestException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
		
	    @ExceptionHandler(NotFoundException.class)
	    public ResponseEntity<String> handleMachineNotFoundException(NotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	
	    @ExceptionHandler(InsertException.class)
	    public ResponseEntity<String> handleMachineInsertException(InsertException ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	    }
	}
	
}
