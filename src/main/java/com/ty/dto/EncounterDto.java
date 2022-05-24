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
public class EncounterDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounter_id;
	private LocalDate date;
	private LocalTime time;
	private String reason;
	private String creatorName;
	@ManyToOne
	@JoinColumn
	private PersonDto personDto;
	@OneToMany(mappedBy = "encounters")
	private List<MedOrderDto> medOreders;
	@ManyToOne
	@JoinColumn
	private BranchDto branchDto;

	public int getEncounter_id() {
		return encounter_id;
	}

	public void setEncounter_id(int encounter_id) {
		this.encounter_id = encounter_id;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public PersonDto getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDto personDto) {
		this.personDto = personDto;
	}

	public List<MedOrderDto> getMedOreders() {
		return medOreders;
	}

	public void setMedOreders(List<MedOrderDto> medOreders) {
		this.medOreders = medOreders;
	}

	public BranchDto getBranchDto() {
		return branchDto;
	}

	public void setBranchDto(BranchDto branchDto) {
		this.branchDto = branchDto;
	}

}
