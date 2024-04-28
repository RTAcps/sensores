package com.rtacps.sensores.dto;

import java.io.Serializable;

import com.rtacps.sensores.entities.Leitura;

public class LeituraDTO implements Serializable{	
	private static final long serialVersionUID = 1L;

	private Long id;
	private Float amount;
	private Long dateTime;
	private Long updateAt;
	
	private SensorDTO sensor;

	public LeituraDTO() {		
	}

	public LeituraDTO(Long id, Float amount, Long dateTime, Long updateAt, SensorDTO sensor) {
		this.id = id;
		this.amount = amount;
		this.dateTime = dateTime;
		this.updateAt = updateAt;
		this.sensor = sensor;
		
	}

	public LeituraDTO(Leitura entity) {
		id = entity.getId();
		amount = entity.getAmount();
		dateTime = entity.getDateTime();
		updateAt = entity.getUpdateAt();
		sensor = new SensorDTO(entity.getSensor());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Long getDateTime() {
		return dateTime;
	}

	public void setDateTime(Long dateTime) {
		this.dateTime = dateTime;
	}

	public Long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}

	public SensorDTO getSensor() {
		return sensor;
	}

	public void setSensor(SensorDTO sensor) {
		this.sensor = sensor;
	}	
		
}
