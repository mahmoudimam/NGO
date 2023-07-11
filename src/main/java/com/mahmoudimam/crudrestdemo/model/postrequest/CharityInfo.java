package com.mahmoudimam.crudrestdemo.model.postrequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class CharityInfo {

	@JsonProperty(value = "categoryId")
	private Long charityId;

	@JsonProperty(value = "charityArName", required = true)
	@NotBlank(message = "charityArName is mandatory")
	private String charityArName;

	@JsonProperty(value = "charityEnName", required = true)
	@NotBlank(message = "charityEnName is mandatory")
	private String charityEnName;

	@JsonProperty(value = "charityCode", required = true)
	@NotBlank(message = "charityCode is mandatory")
	private Long charityCode;

	@JsonProperty(value = "prodlist", required = true)
	private Prodlist prodlist;

	public CharityInfo() {
		super();
	}

	public CharityInfo(Long charityId, @NotBlank(message = "charityArName is mandatory") String charityArName,
			@NotBlank(message = "charityEnName is mandatory") String charityEnName,
			@NotBlank(message = "charityCode is mandatory") Long charityCode, Prodlist prodlist) {
		super();
		this.charityId = charityId;
		this.charityArName = charityArName;
		this.charityEnName = charityEnName;
		this.charityCode = charityCode;
		this.prodlist = prodlist;
	}

	public String getCharityArName() {
		return charityArName;
	}

	public void setCharityArName(String charityArName) {
		this.charityArName = charityArName;
	}

	public String getCharityEnName() {
		return charityEnName;
	}

	public void setCharityEnName(String charityEnName) {
		this.charityEnName = charityEnName;
	}

	public Long getCharityCode() {
		return charityCode;
	}

	public void setCharityCode(Long charityCode) {
		this.charityCode = charityCode;
	}

	public Prodlist getProdlist() {
		return prodlist;
	}

	public void setProdlist(Prodlist prodlist) {
		this.prodlist = prodlist;
	}
	
	public Long getCharityId() {
		return charityId;
	}

	public void setCharityId(Long charityId) {
		this.charityId = charityId;
	}

	@Override
	public String toString() {
		return "CharityInfo [charityId=" + charityId + ", charityArName=" + charityArName + ", charityEnName="
				+ charityEnName + ", charityCode=" + charityCode + ", prodlist=" + prodlist + "]";
	}

}
