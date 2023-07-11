package com.mahmoudimam.crudrestdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahmoudimam.crudrestdemo.entity.Charity;

public interface CharityRepository extends JpaRepository<Charity, Long> {
	
	List<Charity> findByCategoryIdOrderByCategoryIdAsc(Long categoryId);
	List<Charity> findByCategoryId(Long categoryId);
	List<Charity> findByCategoryIdOrderBySortAsc(Long categoryId);

}
