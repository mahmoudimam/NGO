package com.mahmoudimam.crudrestdemo.interfaces;

import java.util.List;

import com.mahmoudimam.crudrestdemo.entity.Category;


public interface CategoryService {
	
    Category getCategoryById(Long CategoryId) throws Exception;

    List<Category> getAllCategories();
    
    List<Category> getAllCategoriesByProductId(Long ProductId);
    
    List<Category> getAllCategoriesByProductIdOrderBySort(Long ProductId);
    
    List<Category> getAllCategoriesByProductIdOrderByCategoryId(Long ProductId);

    Category saveItem(Category category) throws Exception;

    Category updateItem(Category category) throws Exception;

    void deleteItem(Long CategoryId);

}
