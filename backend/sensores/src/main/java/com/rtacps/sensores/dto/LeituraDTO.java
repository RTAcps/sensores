package com.rtacps.sensores.dto;

import com.rtacps.sensores.entities.Leitura;

public class LeituraDTO {

	private Long id;
	private Float amount;
	private Long dateTime;
	private Long updateAt;

	public LeituraDTO() {		
	}

	public LeituraDTO(Long id, Float amount, Long dateTime, Long updateAt) {
		this.id = id;
		this.amount = amount;
		this.dateTime = dateTime;
		this.updateAt = updateAt;
	}

	public LeituraDTO(Leitura entity) {
		id = entity.getId();
		amount = entity.getAmount();
		dateTime = entity.getDateTime();
		updateAt = entity.getUpdateAt();
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
	
}
