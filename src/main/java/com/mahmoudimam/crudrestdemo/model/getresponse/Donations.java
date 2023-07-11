package com.mahmoudimam.crudrestdemo.model.getresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Donations")
@JsonInclude(value = Include.NON_EMPTY)
//@JsonPropertyOrder()
public class Donations {
	
	 @JacksonXmlElementWrapper(localName = "MERLIST", useWrapping = false)
	 @JacksonXmlProperty(localName = "MERLIST")
     @JsonProperty(value = "MERLIST")
	 private List<Merlist> merlist;

	public Donations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donations(List<Merlist> merlist) {
		super();
		this.merlist = merlist;
	}

	public List<Merlist> getMerlist() {
		return merlist;
	}

	public void setMerlist(List<Merlist> merlist) {
		this.merlist = merlist;
	}

	@Override
	public String toString() {
		return "Donations [merlist=" + merlist + "]";
	}
	 
	 

}
