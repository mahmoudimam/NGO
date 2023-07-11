package com.mahmoudimam.crudrestdemo.model.postrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotBlank;

public class Product {

	@JsonProperty(value = "productId")
	private Long productId;

	@JsonProperty(value = "prodArName", required = true)
	@NotBlank(message = "prodArName is mandatory")
	private String prodArName;

	@JsonProperty(value = "prodEnName", required = true)
	@NotBlank(message = "prodEnName is mandatory")
	private String prodEnName;

	@JsonProperty(value = "fixedAmount", required = false)
	@JsonInclude(value = Include.NON_NULL)
	private Long fixedAmount;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productId, @NotBlank(message = "prodArName is mandatory") String prodArName,
			@NotBlank(message = "prodEnName is mandatory") String prodEnName, Long fixedAmount) {
		super();
		this.productId = productId;
		this.prodArName = prodArName;
		this.prodEnName = prodEnName;
		this.fixedAmount = fixedAmount;
	}

	public String getProdArName() {
		return prodArName;
	}

	public void setProdArName(String prodArName) {
		this.prodArName = prodArName;
	}

	public String getProdEnName() {
		return prodEnName;
	}

	public void setProdEnName(String prodEnName) {
		this.prodEnName = prodEnName;
	}

	@JsonInclude(value = Include.NON_NULL)
	public Long getFixedAmount() {
		if (fixedAmount == null) {
			return null;
		}
		return fixedAmount;
	}

	public void setFixedAmount(Long fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodArName=" + prodArName + ", prodEnName=" + prodEnName
				+ ", fixedAmount=" + fixedAmount + "]";
	}

}
