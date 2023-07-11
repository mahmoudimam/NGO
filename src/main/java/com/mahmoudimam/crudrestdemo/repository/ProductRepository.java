package com.mahmoudimam.crudrestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahmoudimam.crudrestdemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
