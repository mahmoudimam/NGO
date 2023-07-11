package com.mahmoudimam.crudrestdemo.model.getresponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value  = Include.NON_NULL)
public class Product {
	

    @JacksonXmlProperty(localName = "PRODID")
	@JsonProperty(value = "PRODID")
    private Long prodId;
    
    @JacksonXmlProperty(localName = "PRODNAME")
	@JsonProperty(value = "PRODNAME")
    private String prodName;
    
    @JacksonXmlProperty(localName = "FIXEDAMOUNT")
    @JsonProperty(value = "FIXEDAMOUNT")
    private Long fixedAmount;
    
    
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(Long prodId, String prodName, Long fixedAmount) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.fixedAmount = fixedAmount;
	}


	public Long getProdId() {
		return prodId;
	}


	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public Long getFixedAmount() {
		return fixedAmount;
	}


	public void setFixedAmount(Long fixedAmount) {
		this.fixedAmount = fixedAmount;
	}


	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", fixedAmount=" + fixedAmount + "]";
	}

    
    

}
