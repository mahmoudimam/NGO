package com.mahmoudimam.crudrestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahmoudimam.crudrestdemo.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, String>{

}
