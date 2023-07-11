package com.mahmoudimam.crudrestdemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "category", schema = "donation_directory")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long categoryId;
	
	private String arName;
	
	private String enName;
	
	private Boolean enabled;
	
	@Column(nullable = false)
	private Long sort;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
	
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	 @JsonIgnore
	private List<Charity> charities;
	 

	public Category() {
		super();
	}

	
	public Category(Long categoryId, String arName, String enName, Boolean enabled, Product product,
			List<Charity> charities, Long sort) {
		super();
		this.categoryId = categoryId;
		this.arName = arName;
		this.enName = enName;
		this.enabled = enabled;
		this.product = product;
		this.charities = charities;
		this.sort = sort;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Charity> getCharities() {
		return charities;
	}

	public void setCharities(List<Charity> charities) {
		this.charities = charities;
	}


	public Long getSort() {
		return sort;
	}


	public void setSort(Long sort) {
		this.sort = sort;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryId=" + categoryId + ", arName=" + arName + ", enName=" + enName
				+ ", enabled=" + enabled + ", sort=" + sort + ", product=" + product + ", charities=" + charities + "]";
	}
	 
	
	 
}
