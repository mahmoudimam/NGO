package com.mahmoudimam.crudrestdemo.model.putrequest;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.mahmoudimam.crudrestdemo.model.postrequest.CharityInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonRootName(value = "")
public class UpdateDonation {
	
	@JsonProperty(value = "productId", required = true)
	@NotBlank(message = "productId is mandatory")
	private Long productId;

	@JsonProperty(value = "categoryArName", required = true)
	@NotBlank(message = "categoryArName is mandatory")
	private String categoryArName;

	@JsonProperty(value = "categoryEnName", required = true)
	@NotBlank(message = "categoryEnName is mandatory")
	private String categoryEnName;

	@JsonProperty(value = "categoryEnabled", required = true)
	@NotBlank(message = "categoryEnabled is mandatory")
	private boolean categoryEnabled;

	@JsonProperty(value = "charityInfo", required = true)
	private List<CharityInfo> charityInfo;
    
    
	
    
    

}
