package com.mahmoudimam.crudrestdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "characteristics", schema = "donation_directory")
public class Characteristics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long characteristicsId;
	
	private String arName;
	
	private String enName;
	
	private Long fixAmount;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "charity_id")
    @JsonIgnore
    private Charity charity;

	
	public Characteristics(Long characteristicsId, String arName, String enName, Long fixAmount, Charity charity) {
		super();
		this.characteristicsId = characteristicsId;
		this.arName = arName;
		this.enName = enName;
		this.fixAmount = fixAmount;
		this.charity = charity;
	}
	
	public Characteristics() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCharacteristicsId() {
		return characteristicsId;
	}

	public void setCharacteristicsId(Long characteristicsId) {
		this.characteristicsId = characteristicsId;
	}

	public String getArName() {
		return arName;
	}

	public void setArName(String arName) {
		this.arName = arName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public Long getFixAmount() {
		return fixAmount;
	}

	public void setFixAmount(Long fixAmount) {
		this.fixAmount = fixAmount;
	}

	public Charity getCharity() {
		return charity;
	}

	public void setCharity(Charity charity) {
		this.charity = charity;
	}
	
	

}
