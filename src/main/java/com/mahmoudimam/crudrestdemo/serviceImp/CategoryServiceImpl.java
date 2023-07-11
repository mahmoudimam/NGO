package com.mahmoudimam.crudrestdemo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahmoudimam.crudrestdemo.entity.Category;
import com.mahmoudimam.crudrestdemo.interfaces.CategoryService;
import com.mahmoudimam.crudrestdemo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category getCategoryById(Long CategoryId) throws Exception {
		return categoryRepository.findById(CategoryId).orElseThrow(() -> {
			throw new RuntimeException(String.format("No Category Exist with id [{}]" + CategoryId));
		});
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category saveItem(Category category) throws Exception {
		try {
			categoryRepository.saveAndFlush(category);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return category;
	}

	@Override
	public Category updateItem(Category category) throws Exception {
		try {
			Category oldCategory = getCategoryById(category.getId());
			if (oldCategory != null) {
				categoryRepository.saveAndFlush(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return category;
	}

	@Override
	public void deleteItem(Long CategoryIdId) {
		categoryRepository.deleteById(CategoryIdId);

	}

	@Override
	public List<Category> getAllCategoriesByProductId(Long ProductId) {

		List<Category> categories = categoryRepository.findByProductId(ProductId);
		if (categories.isEmpty()) {
			return null;
		}
		return categories;
	}

	@Override
	public List<Category> getAllCategoriesByProductIdOrderBySort(Long ProductId) {
		List<Category> categories = categoryRepository.findByProductIdOrderBySortAsc(ProductId);
		if (categories.isEmpty()) {
			return null;
		}
		return categories;
	}

	@Override
	public List<Category> getAllCategoriesByProductIdOrderByCategoryId(Long ProductId) {
		List<Category> categories = categoryRepository.findByProductIdOrderByCategoryIdAsc(ProductId);
		if (categories.isEmpty()) {
			return null;
		}
		return categories;
	}

}
