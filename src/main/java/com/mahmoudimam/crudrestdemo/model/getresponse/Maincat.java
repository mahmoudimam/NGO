package com.mahmoudimam.crudrestdemo.model.getresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Maincat {
	
    @JacksonXmlProperty(localName = "ID")
	@JsonProperty(value = "ID")
    private Long id;
    
    @JacksonXmlProperty(localName = "NAME")
	@JsonProperty(value = "NAME")
    private String name;
    
    @JacksonXmlProperty(localName = "ENABLED")
	@JsonProperty(value = "ENABLED")
    private String enabled;
    
    @JacksonXmlElementWrapper(localName = "MERCHANT", useWrapping = false)
    @JacksonXmlProperty(localName = "MERCHANT")
	@JsonProperty(value = "MERCHANT")
    private List<Merchant> merchant;
    
	public Maincat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Maincat(Long id, String name, String enabled, List<Merchant> merchant) {
		super();
		this.id = id;
		this.name = name;
		this.enabled = enabled;
		this.merchant = merchant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	public List<Merchant> getMerchant() {
		return merchant;
	}

	public void setMerchant(List<Merchant> merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "Maincat [id=" + id + ", name=" + name + ", enabled=" + enabled + ", merchant=" + merchant + "]";
	}

    

}
