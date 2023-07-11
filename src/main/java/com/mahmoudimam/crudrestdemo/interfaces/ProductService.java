package com.mahmoudimam.crudrestdemo.interfaces;

import java.util.List;

import com.mahmoudimam.crudrestdemo.entity.Product;


public interface ProductService {
	
    Product getProductById(Long productId) throws Exception;

    List<Product> getAllProducts();

    Product saveItem(Product product) throws Exception;

    Product updateItem(Product product) throws Exception;

    void deleteItem(Long ProuctId);

}
