package com.mahmoudimam.crudrestdemo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahmoudimam.crudrestdemo.entity.Charity;
import com.mahmoudimam.crudrestdemo.interfaces.CharityService;
import com.mahmoudimam.crudrestdemo.repository.CharityRepository;

@Service
public class CharityServiceImpl implements CharityService {

	@Autowired
	CharityRepository charityRepository;

	@Override
	public Charity getCharityById(Long CharityId) throws Exception {
		return charityRepository.findById(CharityId).orElseThrow(() -> {
			throw new RuntimeException(String.format("No Charity Exist with id [{}]" + CharityId));
		});
	}

	@Override
	public List<Charity> getAllCharities() {
		return charityRepository.findAll();
	}

	@Override
	public Charity saveItem(Charity Charity) throws Exception {
		try {
			charityRepository.saveAndFlush(Charity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return Charity;
	}

	@Override
	public Charity updateItem(Charity Charity) throws Exception {
		try {
			Charity oldCharity = getCharityById(Charity.getId());
			if (oldCharity != null) {
				charityRepository.saveAndFlush(Charity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return Charity;
	}

	@Override
	public void deleteItem(Long CharityIdId) {
		charityRepository.deleteById(CharityIdId);

	}

	@Override
	public List<Charity> getAllCharitiesByCategoryId(Long categoryId) {
		List<Charity> categories = charityRepository.findByCategoryId(categoryId);
		if (categories.isEmpty()) {
			return null;
		}
		return categories;
	}

	@Override
	public List<Charity> getAllCharitiesByCategoryIdOrderBySortAsc(Long categoryId) {
		List<Charity> categories = charityRepository.findByCategoryIdOrderBySortAsc(categoryId);
		if (categories.isEmpty()) {
			return null;
		}
		return categories;
	}

	@Override
	public List<Charity> getAllCharitiesByCategoryIdOrderByCategoryIdAsc(Long categoryId) {
		List<Charity> categories = charityRepository.findByCategoryIdOrderByCategoryIdAsc(categoryId);

		if (categories.isEmpty()) {
			return null;
		}
		return categories;
	}

}
