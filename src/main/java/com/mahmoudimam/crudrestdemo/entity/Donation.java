package com.mahmoudimam.crudrestdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donation", schema = "donation_directory")
public class Donation {
	
	@Id
	@Column(name="SERVICE_NAME")
	private String SERVICE_NAME;
	
	@Column(name = "SERVICE_CONFIG", columnDefinition = "TEXT")
	private String SERVICE_CONFIG;
	
	

	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Donation(String sERVICE_NAME, String sERVICE_CONFIG) {
		super();
		SERVICE_NAME = sERVICE_NAME;
		SERVICE_CONFIG = sERVICE_CONFIG;
	}



	public String getSERVICE_NAME() {
		return SERVICE_NAME;
	}



	public void setSERVICE_NAME(String sERVICE_NAME) {
		SERVICE_NAME = sERVICE_NAME;
	}



	public String getSERVICE_CONFIG() {
		return SERVICE_CONFIG;
	}



	public void setSERVICE_CONFIG(String sERVICE_CONFIG) {
		SERVICE_CONFIG = sERVICE_CONFIG;
	}
	
	


}
