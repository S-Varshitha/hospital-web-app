package com.ty.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HospitalDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospital_id;
	private String hospital_name;
	private String website;
	private String gst;
	@OneToMany(mappedBy = "hospitalDto")
	private List<BranchDto> branches;

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public List<BranchDto> getBranches() {
		return branches;
	}

	public void setBranches(List<BranchDto> branches) {
		this.branches = branches;
	}

}
