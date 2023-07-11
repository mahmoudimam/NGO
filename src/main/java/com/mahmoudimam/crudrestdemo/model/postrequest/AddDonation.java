package com.mahmoudimam.crudrestdemo.model.postrequest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.validation.constraints.NotBlank;

@JsonRootName(value = "")
public class AddDonation {

	@JsonProperty(value = "productId", required = true)
	//@NotBlank(message = "productId is mandatory")
	private Long productId;

	@JsonProperty(value = "categoryId")
	private Long categoryId;

	@JsonProperty(value = "categoryArName", required = true)
	@NotBlank(message = "categoryArName is mandatory")
	private String categoryArName;

	@JsonProperty(value = "categoryEnName", required = true)
	@NotBlank(message = "categoryEnName is mandatory")
	private String categoryEnName;

	@JsonProperty(value = "categoryEnabled", required = true)
	//@NotBlank(message = "categoryEnabled is mandatory")
	private boolean categoryEnabled;
	
	@JsonProperty(value = "sort", required = true)
	private Long sort;

	@JsonProperty(value = "charityInfo", required = true)
	private List<CharityInfo> charityInfo;
	

	public AddDonation() {
		super();
	}

	public AddDonation(@NotBlank(message = "productId is mandatory") Long productId, Long categoryId,
			@NotBlank(message = "categoryArName is mandatory") String categoryArName,
			@NotBlank(message = "categoryEnName is mandatory") String categoryEnName,
			@NotBlank(message = "categoryEnabled is mandatory") boolean categoryEnabled,
			List<CharityInfo> charityInfo, Long sort) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.categoryArName = categoryArName;
		this.categoryEnName = categoryEnName;
		this.categoryEnabled = categoryEnabled;
		this.charityInfo = charityInfo;
		this.sort = sort;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getCategoryArName() {
		return categoryArName;
	}

	public void setCategoryArName(String categoryArName) {
		this.categoryArName = categoryArName;
	}

	public String getCategoryEnName() {
		return categoryEnName;
	}

	public void setCategoryEnName(String categoryEnName) {
		this.categoryEnName = categoryEnName;
	}

	public boolean getCategoryEnabled() {
		return categoryEnabled;
	}

	public void setCategoryEnabled(boolean categoryEnabled) {
		this.categoryEnabled = categoryEnabled;
	}

	public List<CharityInfo> getCharityInfo() {
		return charityInfo;
	}

	public void setCharityInfo(List<CharityInfo> charityInfo) {
		this.charityInfo = charityInfo;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "AddDonation [productId=" + productId + ", categoryId=" + categoryId + ", categoryArName="
				+ categoryArName + ", categoryEnName=" + categoryEnName + ", categoryEnabled=" + categoryEnabled
				+ ", charityInfo=" + charityInfo + "]";
	}

}
