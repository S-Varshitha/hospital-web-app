package com.ty.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BranchDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branch_id;
	private String branch_name;
	private long branch_phone;
	private String email;
	@ManyToOne
	@JoinColumn
	private HospitalDto hospitalDto;
	@OneToOne
	@JoinColumn
	private AdressDto adressDto;
	@OneToMany(mappedBy = "branchDto")
	private List<EncounterDto> encounterDtos;
	@OneToMany(mappedBy = "branch")
	private List<User> users;

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public long getBranch_phone() {
		return branch_phone;
	}

	public void setBranch_phone(long branch_phone) {
		this.branch_phone = branch_phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HospitalDto getHospitalDto() {
		return hospitalDto;
	}

	public void setHospitalDto(HospitalDto hospitalDto) {
		this.hospitalDto = hospitalDto;
	}

	public AdressDto getAdressDto() {
		return adressDto;
	}

	public void setAdressDto(AdressDto adressDto) {
		this.adressDto = adressDto;
	}

	public List<EncounterDto> getEncounterDtos() {
		return encounterDtos;
	}

	public void setEncounterDtos(List<EncounterDto> encounterDtos) {
		this.encounterDtos = encounterDtos;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
