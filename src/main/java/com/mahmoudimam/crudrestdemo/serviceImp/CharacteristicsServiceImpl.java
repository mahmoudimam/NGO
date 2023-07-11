package com.mahmoudimam.crudrestdemo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahmoudimam.crudrestdemo.entity.Characteristics;
import com.mahmoudimam.crudrestdemo.interfaces.CharacteristicsService;
import com.mahmoudimam.crudrestdemo.repository.CharacteristicsRepository;

@Service
public class CharacteristicsServiceImpl implements CharacteristicsService {

	@Autowired
	CharacteristicsRepository characteristicsRepository;

	@Override
	public Characteristics getCharacteristicsById(Long CharacteristicsId) throws Exception {
		return characteristicsRepository.findById(CharacteristicsId).orElseThrow(() -> {
			throw new RuntimeException(String.format("No Characteristics Exist with id [{}]" + CharacteristicsId));
		});
	}

	@Override
	public List<Characteristics> getAllCharacteristics() {
		return characteristicsRepository.findAll();
	}

	@Override
	public Characteristics saveItem(Characteristics Characteristics) throws Exception {
		try {
			characteristicsRepository.saveAndFlush(Characteristics);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return Characteristics;
	}

	@Override
	public Characteristics updateItem(Characteristics Characteristics) throws Exception {
		try {
			Characteristics oldCharacteristics = getCharacteristicsById(Characteristics.getId());
			if (oldCharacteristics != null) {
				characteristicsRepository.saveAndFlush(Characteristics);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return Characteristics;
	}

	@Override
	public void deleteItem(Long CharacteristicsId) {
		characteristicsRepository.deleteById(CharacteristicsId);

	}

	@Override
	public List<Characteristics> getAllCharacteristicsByCharity(Long charityId) {
		return characteristicsRepository.findByCharityId(charityId);
	}

}
