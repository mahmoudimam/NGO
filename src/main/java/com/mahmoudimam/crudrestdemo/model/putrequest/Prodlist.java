package com.mahmoudimam.crudrestdemo.model.putrequest;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prodlist {
	
	@JsonProperty(value = "product", required = true)
	private ArrayList<Product> product;

	public Prodlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prodlist(ArrayList<Product> product) {
		super();
		this.product = product;
	}

	public ArrayList<Product> getProduct() {
		return product;
	}

	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Prodlist [product=" + product + "]";
	}
	
	

}
