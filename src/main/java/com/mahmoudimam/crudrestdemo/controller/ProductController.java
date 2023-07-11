package com.mahmoudimam.crudrestdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import com.mahmoudimam.crudrestdemo.entity.Product;
import com.mahmoudimam.crudrestdemo.interfaces.ProductService;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> saveproduct(@RequestBody Product product) throws Exception {
		return new ResponseEntity<>(productService.saveItem(product), HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

	}

	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) throws Exception {
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);

	}

}
