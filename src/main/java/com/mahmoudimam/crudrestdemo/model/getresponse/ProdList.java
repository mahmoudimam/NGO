package com.mahmoudimam.crudrestdemo.model.getresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ProdList {
	
	@JacksonXmlElementWrapper(localName = "PRODUCT", useWrapping = false)
    @JacksonXmlProperty(localName = "PRODUCT")
	@JsonProperty(value = "PRODUCT")
    private List<Product> product;

	public ProdList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdList(List<Product> product) {
		super();
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProdList [product=" + product + "]";
	}

    
	
}
