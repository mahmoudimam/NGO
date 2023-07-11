package com.mahmoudimam.crudrestdemo.model.putrequest;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CharityInfo {
	
	@JsonProperty(value = "charityId", required = true)
	private int charityId;
	
	@JsonProperty(value = "charityName", required = true)
	private String charityName;
	
	@JsonProperty(value = "charityCode", required = true)
	private int charityCode;
	
	@JsonProperty(value = "prodlist", required = true)
	private Prodlist prodlist;

	public CharityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharityInfo(int charityId, String charityName, int charityCode, Prodlist prodlist) {
		super();
		this.charityId = charityId;
		this.charityName = charityName;
		this.charityCode = charityCode;
		this.prodlist = prodlist;
	}

	public int getCharityId() {
		return charityId;
	}

	public void setCharityId(int charityId) {
		this.charityId = charityId;
	}

	public String getCharityName() {
		return charityName;
	}

	public void setCharityName(String charityName) {
		this.charityName = charityName;
	}

	public int getCharityCode() {
		return charityCode;
	}

	public void setCharityCode(int charityCode) {
		this.charityCode = charityCode;
	}

	public Prodlist getProdlist() {
		return prodlist;
	}

	public void setProdlist(Prodlist prodlist) {
		this.prodlist = prodlist;
	}

	@Override
	public String toString() {
		return "CharityInfo [charityId=" + charityId + ", charityName=" + charityName + ", charityCode=" + charityCode
				+ ", prodlist=" + prodlist + "]";
	}

    
}
