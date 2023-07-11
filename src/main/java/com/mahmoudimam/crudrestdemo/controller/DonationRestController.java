package com.mahmoudimam.crudrestdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahmoudimam.crudrestdemo.entity.Category;
import com.mahmoudimam.crudrestdemo.entity.Characteristics;
import com.mahmoudimam.crudrestdemo.entity.Charity;
import com.mahmoudimam.crudrestdemo.interfaces.Processes;
import com.mahmoudimam.crudrestdemo.model.getresponse.Donations;
import com.mahmoudimam.crudrestdemo.model.postrequest.AddCharity;
import com.mahmoudimam.crudrestdemo.model.postrequest.AddDonation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ngo")
public class DonationRestController {

	@Autowired
	Processes processes;

	@PostMapping(value = "/donation", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<AddDonation> saveDonation(@Valid @RequestBody AddDonation addDonation) {

		try {

			return new ResponseEntity<AddDonation>(processes.createDonation(addDonation), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Can't Create Statement - " + addDonation.getProductId());
		}

	}
	
	@PostMapping(value = "/charity", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<AddCharity> saveCharity(@Valid @RequestBody AddCharity addCharity) {

		try {

			return new ResponseEntity<AddCharity>(processes.createCharity(addCharity), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Can't Create Statement - " + addCharity.getCategoryId());
		}

	}

	@GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> findAllCategories() throws Exception {

		try {

			return new ResponseEntity<List<Category>>(processes.getAllCategories(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Can't Get All Categories - ");
		}

	}

	@GetMapping(value = "/charity/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Charity>> findAllCharityByCategoryId(@PathVariable("categoryId") Long categoryId)
			throws Exception {

		try {

			return new ResponseEntity<List<Charity>>(processes.getAllCharityByCategoryIdOrderBySortAscs(categoryId),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Can't Get All Charity - ");
		}

	}

	@GetMapping(value = "/characteistics/{charityId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Characteristics>> findAllCharacteristicsByCharityId(
			@PathVariable("charityId") Long charityId) throws Exception {

		try {

			return new ResponseEntity<List<Characteristics>>(processes.getAllCharacteristicsByCharityId(charityId),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Can't Get All Characteristics - ");
		}

	}

	@GetMapping(value = "/donation/{productId}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Donations> getAllDonation(@PathVariable("productId") Long productId) throws Exception {

		try {

			return new ResponseEntity<Donations>(processes.getAllDonation(productId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Can't Get All Donation - ");
		}

	}

//	@PutMapping(value = "/donation/VFCashDonations", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Donations> update(@Valid @RequestBody Root root) {
//		Donation don = null;
//		Donations dons = null;
//		try {
//			don = dao.findById(root.getServiceName());
//			dons = new XmlUtils<>(Donations.class).convertString_To_XMLObject(don.getSERVICE_CONFIG());
//
//			//****************************************************//
//			if(root.getAddCharity()) {
//				//dons = p.UpdateDonation(dons, root);
//			}else {
//				//dons = p.UpdateDonation(dons, root);
//			}
//			
//			String xmlConfig = new XmlUtils<>(Donations.class).convertXMLObject_To_String(dons);
//			
//			xmlConfig = "<?xml version=\"1.0\" encoding=\"UTF8\"?>\n" + xmlConfig;
//			
//			don.setSERVICE_NAME(root.getServiceName());
//			don.setSERVICE_CONFIG(xmlConfig);
//			
//			System.out.println(xmlConfig);
//			
//			
//			//****************************************************//
//
//
//
//			System.out.println(dons);
//			
//			dao.save(don);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("Can't Update Statement - " + root.getServiceName());
//		}
//		 
//		return new ResponseEntity<Donations>(dons, HttpStatus.CREATED);
//
//	}

}
