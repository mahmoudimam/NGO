package com.mahmoudimam.crudrestdemo.model.getresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Merlist {
	
    @JacksonXmlProperty(localName = "LANGUAGE")
	@JsonProperty(value = "LANGUAGE")
    private String language;
    
	 @JacksonXmlElementWrapper(localName = "MAINCAT", useWrapping = false)
	 @JacksonXmlProperty(localName = "MAINCAT")
	 @JsonProperty(value = "MAINCAT")
	 private List<Maincat> maincat;

	public Merlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Merlist(String language, List<Maincat> maincat) {
		super();
		this.language = language;
		this.maincat = maincat;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Maincat> getMaincat() {
		return maincat;
	}

	public void setMaincat(List<Maincat> maincat) {
		this.maincat = maincat;
	}

	@Override
	public String toString() {
		return "Merlist [language=" + language + ", maincat=" + maincat + "]";
	}


    
    

}
