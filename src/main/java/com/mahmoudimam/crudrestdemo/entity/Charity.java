package com.mahmoudimam.crudrestdemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "charity", schema = "donation_directory")
public class Charity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long charityId;

	private String arName;

	private String enName;

	private Long merCode;
	
	private Long sort;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "charity")
	@JsonIgnore
	private List<Characteristics> characteristics;

	public Charity(Long charityId, String arName, String enName, Long merCode, Category category,
			List<Characteristics> characteristics, Long sort) {
		super();
		this.charityId = charityId;
		this.arName = arName;
		this.enName = enName;
		this.merCode = merCode;
		this.category = category;
		this.characteristics = characteristics;
		this.sort = sort;
	}
	

	public Charity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCharityId() {
		return charityId;
	}

	public void setCharityId(Long charityId) {
		this.charityId = charityId;
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

	public Long getMerCode() {
		return merCode;
	}

	public void setMerCode(Long merCode) {
		this.merCode = merCode;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Characteristics> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<Characteristics> characteristics) {
		this.characteristics = characteristics;
	}
	
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

}
