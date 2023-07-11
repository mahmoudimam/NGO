package com.mahmoudimam.crudrestdemo.model.postrequest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value = "")
public class AddCharity {


	@JsonProperty(value = "categoryId")
	private Long categoryId;


	@JsonProperty(value = "charityInfo", required = true)
	private List<CharityInfo> charityInfo;
	

	public AddCharity() {
		super();
	}

	public AddCharity(Long categoryId,
			List<CharityInfo> charityInfo) {
		super();
		this.categoryId = categoryId;
		this.charityInfo = charityInfo;
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

	

}
