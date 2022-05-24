package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdressDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;
	private String state;
	private String district;
	private long pincode;
	private String address;
	@OneToOne(mappedBy = "adressDto")
	private BranchDto branchDto;

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BranchDto getBranchDto() {
		return branchDto;
	}

	public void setBranchDto(BranchDto branchDto) {
		this.branchDto = branchDto;
	}

}
