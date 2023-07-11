package com.mahmoudimam.crudrestdemo.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahmoudimam.crudrestdemo.entity.Donation;
import com.mahmoudimam.crudrestdemo.interfaces.DonationService;
import com.mahmoudimam.crudrestdemo.repository.DonationRepository;



@Service
public class DonationServiceImpl implements DonationService {
	
	@Autowired
	private DonationRepository dao;
	
	@Override
	public Donation save(Donation dons) {
		// TODO Auto-generated method stub
		return dao.save(dons);
	}



	@Override
	public Donation findById(String serviceName) {
		Optional<Donation> don = dao.findById(serviceName);
		
		Donation theDonation = null;
		
		if (don.isPresent()) {
			theDonation = don.get();
		}else {
			throw new RuntimeException("Did not find Service Name - "+serviceName);
		}
		return theDonation;
	}

}
