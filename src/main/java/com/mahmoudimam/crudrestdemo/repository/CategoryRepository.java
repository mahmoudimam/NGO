package com.mahmoudimam.crudrestdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahmoudimam.crudrestdemo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	List<Category> findByProductId(Long ProductId);
	List<Category> findByProductIdOrderByCategoryIdAsc(Long ProductId);
	List<Category> findByProductIdOrderBySortAsc(Long ProductId);

}
