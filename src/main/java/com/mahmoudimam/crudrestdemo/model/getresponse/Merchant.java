package com.mahmoudimam.crudrestdemo.model.getresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Merchant {
	
    @JacksonXmlProperty(localName = "MERID")
    @JsonProperty(value = "MERID")
    private Long merId;
    
    @JacksonXmlProperty(localName = "MERNAME")
    @JsonProperty(value = "MERNAME")
    private String merName;
    
    @JacksonXmlProperty(localName = "MERCODE")
    @JsonProperty(value = "MERCODE")
    private Long merCode;
    
    //@JacksonXmlElementWrapper(localName = "PRODLIST", useWrapping = false)
    @JacksonXmlProperty(localName = "PRODLIST")
    @JsonProperty(value = "PRODLIST")
    private ProdList prodlist;
    
	public Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Merchant(Long merId, String merName, Long merCode, ProdList prodlist) {
		super();
		this.merId = merId;
		this.merName = merName;
		this.merCode = merCode;
		this.prodlist = prodlist;
	}



	public Long getMerId() {
		return merId;
	}

	public void setMerId(Long merId) {
		this.merId = merId;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public Long getMerCode() {
		return merCode;
	}

	public void setMerCode(Long merCode) {
		this.merCode = merCode;
	}

	
	public ProdList getProdlist() {
		return prodlist;
	}



	public void setProdlist(ProdList prodlist) {
		this.prodlist = prodlist;
	}



	@Override
	public String toString() {
		return "Merchant [merId=" + merId + ", merName=" + merName + ", merCode=" + merCode + ", prodlist=" + prodlist
				+ "]";
	}


    

}
