package com.mahmoudimam.crudrestdemo.interfaces;

import java.util.List;

import com.mahmoudimam.crudrestdemo.entity.Category;
import com.mahmoudimam.crudrestdemo.entity.Characteristics;
import com.mahmoudimam.crudrestdemo.entity.Charity;
import com.mahmoudimam.crudrestdemo.model.getresponse.Donations;
import com.mahmoudimam.crudrestdemo.model.postrequest.AddCharity;
import com.mahmoudimam.crudrestdemo.model.postrequest.AddDonation;
import com.mahmoudimam.crudrestdemo.model.postrequest.CharityInfo;
import com.mahmoudimam.crudrestdemo.model.postrequest.Prodlist;

public interface Processes {
	
	//Donations UpdateDonation(Donations dons, Root root);
	AddDonation createDonation(AddDonation addDonation) throws Exception;
	AddCharity createCharity(AddCharity addCharity) throws Exception;
	List<Charity> saveCharity(List<CharityInfo> charityInfo, Category category ,Long categoryId) throws Exception;
	List<Characteristics> saveCharacteristics(Prodlist prodlist, Charity charity ,Long charityId) throws Exception;
	List<Category> getAllCategories();
	List<Charity> getAllCharityByCategoryId(Long categoryId);
	List<Charity> getAllCharityByCategoryIdOrderBySortAscs(Long categoryId);
	List<Characteristics> getAllCharacteristicsByCharityId(Long charityId);
	Donations getAllDonation(Long productId);

}
