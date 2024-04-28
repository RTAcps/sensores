package com.rtacps.sensores.dto;

import java.io.Serializable;

import com.rtacps.sensores.entities.Sensor;

public class SensorDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	private String name;
	private Long timestamp;
	private Long data;
	private Float getValue;
	private Float setpoint;
	
	private MachineDTO machine;
	
	public SensorDTO() {		
	}

	public SensorDTO(Long id, String name, Long timestamp, Long data, Float getValue, Float setpoint, MachineDTO machine) {
		this.id = id;
		this.name = name;
		this.timestamp = timestamp;
		this.data = data;
		this.getValue = getValue;
		this.setpoint = setpoint;
		this.machine = machine;
	}
	
	public SensorDTO(Sensor entity) {
		id = entity.getId();
		name = entity.getName();
		timestamp = entity.getTimestamp();
		data = entity.getData();
		getValue = entity.getGetValue();
		setpoint = entity.getSetpoint();
		machine = new MachineDTO(entity.getMachine());
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

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public Float getGetValue() {
		return getValue;
	}

	public void setGetValue(Float getValue) {
		this.getValue = getValue;
	}

	public Float getSetpoint() {
		return setpoint;
	}

	public void setSetpoint(Float setpoint) {
		this.setpoint = setpoint;
	}

	public MachineDTO getMachine() {
		return machine;
	}

	public void setMachine(MachineDTO machine) {
		this.machine = machine;
	}	

}
