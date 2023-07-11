package com.mahmoudimam.crudrestdemo.model.putrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Product {
	
	@JsonProperty(value = "prodId", required = true)
	private int prodId;
	
	@JsonProperty(value = "prodName", required = true)
	private String prodName;
	
	@JsonProperty(value = "fixedAmount", required = false)
	@JsonInclude(value  = Include.NON_NULL)
	private Integer fixedAmount;
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Product(int prodId, String prodName, Integer fixedAmount) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.fixedAmount = fixedAmount;
	}



	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@JsonInclude(value  = Include.NON_NULL)
	public Integer getFixedAmount() {
		if(fixedAmount == null) {
			return 0;
		}
		return fixedAmount;
	}

	public void setFixedAmount(Integer fixedAmount) {
		this.fixedAmount = fixedAmount;
	}



	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", fixedAmount=" + fixedAmount + "]";
	}
	
	

}
