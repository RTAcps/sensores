package com.rtacps.sensores.dto;

import java.io.Serializable;

import com.rtacps.sensores.entities.Machine;

public class MachineDTO implements Serializable{	
	private static final long serialVersionUID = 1L;

	private Long id;	
	private String name;
	private String description;
	private Long createAt;
	
	public MachineDTO() {		
	}
	
	public MachineDTO(Long id, String name, String description, Long createAt) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createAt = createAt;
	}

	public MachineDTO(Machine entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		createAt = entity.getCreateAt();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		
}
