package com.mahmoudimam.crudrestdemo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahmoudimam.crudrestdemo.entity.Product;
import com.mahmoudimam.crudrestdemo.interfaces.ProductService;
import com.mahmoudimam.crudrestdemo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product getProductById(Long productId) throws Exception {
		return productRepository.findById(productId).orElseThrow(() -> {
			throw new RuntimeException(String.format("No Product Exist with id [{}]" + productId));
		});
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveItem(Product product) throws Exception {
		try {
			productRepository.saveAndFlush(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return product;
	}

	@Override
	public Product updateItem(Product product) throws Exception {
		try {
			Product oldProduct = getProductById(product.getId());
			if (oldProduct != null) {
				productRepository.saveAndFlush(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return product;
	}

	@Override
	public void deleteItem(Long ProuctId) {
		productRepository.deleteById(ProuctId);

	}

}
