package com.ty.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MedOrderDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private int bill_number;
	private LocalDate date;
	private LocalTime time;
	private String creatorName;
	private String message;
	@ManyToOne
	@JoinColumn
	private EncounterDto encounters;
	@OneToMany(mappedBy = "medOrders")
	private List<ItemDto> items;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getBill_number() {
		return bill_number;
	}

	public void setBill_number(int bill_number) {
		this.bill_number = bill_number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public EncounterDto getEncounters() {
		return encounters;
	}

	public void setEncounters(EncounterDto encounters) {
		this.encounters = encounters;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

}
