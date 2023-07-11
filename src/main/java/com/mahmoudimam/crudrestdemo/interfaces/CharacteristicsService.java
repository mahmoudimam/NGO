package com.mahmoudimam.crudrestdemo.interfaces;

import java.util.List;

import com.mahmoudimam.crudrestdemo.entity.Characteristics;


public interface CharacteristicsService {
	
	Characteristics getCharacteristicsById(Long CharacteristicsId) throws Exception;

    List<Characteristics> getAllCharacteristics();
    
    List<Characteristics> getAllCharacteristicsByCharity(Long charityId);

    Characteristics saveItem(Characteristics characteristics) throws Exception;

    Characteristics updateItem(Characteristics characteristics) throws Exception;

    void deleteItem(Long CharacteristicsId);

}
