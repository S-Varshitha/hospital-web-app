package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	private String item_name;
	private double cost;
	private int quantity;
	private String message;
	@ManyToOne
	@JoinColumn
	private MedOrderDto medOrders;

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MedOrderDto getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(MedOrderDto medOrders) {
		this.medOrders = medOrders;
	}

}
