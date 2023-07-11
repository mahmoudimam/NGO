package com.mahmoudimam.crudrestdemo.interfaces;

import java.util.List;

import com.mahmoudimam.crudrestdemo.entity.Charity;


public interface CharityService {
	
	Charity getCharityById(Long CharityId) throws Exception;

    List<Charity> getAllCharities();
    
    List<Charity> getAllCharitiesByCategoryId(Long categoryId);
    
    List<Charity> getAllCharitiesByCategoryIdOrderBySortAsc(Long categoryId);
    
    List<Charity> getAllCharitiesByCategoryIdOrderByCategoryIdAsc(Long categoryId);

    Charity saveItem(Charity charity) throws Exception;

    Charity updateItem(Charity charity) throws Exception;

    void deleteItem(Long CharityId);

}
