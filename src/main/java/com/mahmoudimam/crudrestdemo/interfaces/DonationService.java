package com.mahmoudimam.crudrestdemo.interfaces;


import com.mahmoudimam.crudrestdemo.entity.Donation;

public interface DonationService {
	
	Donation findById(String serviceName);
	Donation save(Donation dons);

}
