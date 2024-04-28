package com.rtacps.sensores.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sensor")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Long timestamp;
	private Long data;
	private Float getValue;
	private Float setpoint;
	
	@ManyToOne
	@JoinColumn(name = "machine_id")
	private Machine machine;

	public Sensor() {
		this.timestamp = Instant.now().toEpochMilli();
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

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
}
