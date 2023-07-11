package com.mahmoudimam.crudrestdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahmoudimam.crudrestdemo.entity.Characteristics;

public interface CharacteristicsRepository extends JpaRepository<Characteristics, Long>{

	List<Characteristics> findByCharityId(Long charityId);
}
