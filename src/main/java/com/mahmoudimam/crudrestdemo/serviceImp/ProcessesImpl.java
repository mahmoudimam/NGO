package com.mahmoudimam.crudrestdemo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahmoudimam.crudrestdemo.entity.Category;
import com.mahmoudimam.crudrestdemo.entity.Characteristics;
import com.mahmoudimam.crudrestdemo.entity.Charity;
import com.mahmoudimam.crudrestdemo.entity.Product;
import com.mahmoudimam.crudrestdemo.interfaces.CategoryService;
import com.mahmoudimam.crudrestdemo.interfaces.CharacteristicsService;
import com.mahmoudimam.crudrestdemo.interfaces.CharityService;
import com.mahmoudimam.crudrestdemo.interfaces.Processes;
import com.mahmoudimam.crudrestdemo.interfaces.ProductService;
import com.mahmoudimam.crudrestdemo.model.getresponse.Donations;
import com.mahmoudimam.crudrestdemo.model.getresponse.Maincat;
import com.mahmoudimam.crudrestdemo.model.getresponse.Merchant;
import com.mahmoudimam.crudrestdemo.model.getresponse.Merlist;
import com.mahmoudimam.crudrestdemo.model.getresponse.ProdList;
import com.mahmoudimam.crudrestdemo.model.postrequest.AddCharity;
import com.mahmoudimam.crudrestdemo.model.postrequest.AddDonation;
import com.mahmoudimam.crudrestdemo.model.postrequest.CharityInfo;
import com.mahmoudimam.crudrestdemo.model.postrequest.Prodlist;

@Service
public class ProcessesImpl implements Processes {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	CharityService charityService;

	@Autowired
	CharacteristicsService characteristicsService;

	@Override
	public AddDonation createDonation(AddDonation addDonation) throws Exception {

		List<Category> categories = categoryService
				.getAllCategoriesByProductIdOrderByCategoryId(addDonation.getProductId());
		Long CategoryId = null;

		if (categories != null) {
			CategoryId = categories.get(categories.size() - 1).getCategoryId() + 1;
		} else {
			CategoryId = (long) 1;
		}

		Product product = productService.getProductById(addDonation.getProductId());
		Category category = new Category(CategoryId, addDonation.getCategoryArName(), addDonation.getCategoryEnName(),
				addDonation.getCategoryEnabled(), product, null, CategoryId);
		addDonation.setCategoryId(CategoryId);
		addDonation.setSort(CategoryId);
		categoryService.saveItem(category);
		saveCharity(addDonation.getCharityInfo(), category, category.getCategoryId());

		return addDonation;
	}

	@Override
	public AddCharity createCharity(AddCharity addCharity) throws Exception {
		Category category = categoryService.getCategoryById(addCharity.getCategoryId());
		saveCharity(addCharity.getCharityInfo(), category, category.getCategoryId());
		return addCharity;
	}

	@Override
	public List<Charity> saveCharity(List<CharityInfo> charityInfo, Category category, Long categoryId)
			throws Exception {
		List<Charity> charities = charityService.getAllCharitiesByCategoryIdOrderByCategoryIdAsc(categoryId);
		List<Charity> charitys = new ArrayList<Charity>();
		Long charityId = null;
		Long sort = null;

		if (charities != null) {
			charityId = charities.get(charities.size() - 1).getCharityId() + 1;
			sort = charities.get(charities.size() - 1).getId() + 1;
		} else {
			charityId = (categoryId * 10) + 1;
			sort = categoryId;
		}

		for (int i = 0; i < charityInfo.size(); i++) {
			Charity charity = new Charity(charityId + i, charityInfo.get(i).getCharityArName(),
					charityInfo.get(i).getCharityEnName(), charityInfo.get(i).getCharityCode(), category, null,
					sort + i);
			charityInfo.get(i).setCharityId(charity.getCharityId());
			charitys.add(charityService.saveItem(charity));

			saveCharacteristics(charityInfo.get(i).getProdlist(), charity, charity.getCharityId());

		}

		return charities;
	}

	@Override
	public List<Characteristics> saveCharacteristics(Prodlist prodlist, Charity charity, Long charityId)
			throws Exception {
		List<Characteristics> characteristics = new ArrayList<Characteristics>();
		Long charateristicsId = (charityId * 10) + 1;

		for (int i = 0; i < prodlist.getProduct().size(); i++) {

			Characteristics charistics = new Characteristics(charateristicsId + i,
					prodlist.getProduct().get(i).getProdArName(), prodlist.getProduct().get(i).getProdEnName(),
					prodlist.getProduct().get(i).getFixedAmount(), charity);
			prodlist.getProduct().get(i).setProductId(charistics.getCharacteristicsId());
			characteristics.add(characteristicsService.saveItem(charistics));

		}
		return characteristics;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryService.getAllCategoriesByProductIdOrderBySort((long) 1);
	}

	@Override
	public List<Charity> getAllCharityByCategoryId(Long categoryId) {
		return charityService.getAllCharitiesByCategoryId(categoryId);
	}

	@Override
	public List<Characteristics> getAllCharacteristicsByCharityId(Long charityId) {
		return characteristicsService.getAllCharacteristicsByCharity(charityId);
	}

	@Override
	public List<Charity> getAllCharityByCategoryIdOrderBySortAscs(Long categoryId) {
		return charityService.getAllCharitiesByCategoryIdOrderBySortAsc(categoryId);
	}

	@Override
	public Donations getAllDonation(Long productId) {
		List<Category> categories = categoryService.getAllCategoriesByProductIdOrderBySort(productId);

		List<Merlist> merlists = new ArrayList<>();

		List<Maincat> arMaincats = new ArrayList<>();
		List<Maincat> enMaincats = new ArrayList<>();

		List<Merchant> arMerchants = new ArrayList<>();
		List<Merchant> enMerchants = new ArrayList<>();

		for (int i = 0; i < categories.size(); i++) {
			List<Charity> charities = charityService
					.getAllCharitiesByCategoryIdOrderBySortAsc(categories.get(i).getCategoryId());
			for (int j = 0; j < charities.size(); j++) {
				List<Characteristics> characteristics = characteristicsService
						.getAllCharacteristicsByCharity(charities.get(j).getId());

				ProdList arProdList = new ProdList();
				ProdList enProdList = new ProdList();

				List<com.mahmoudimam.crudrestdemo.model.getresponse.Product> arProducts = new ArrayList<>();
				List<com.mahmoudimam.crudrestdemo.model.getresponse.Product> enProducts = new ArrayList<>();

				for (int z = 0; z < characteristics.size(); z++) {
					arProducts.add(new com.mahmoudimam.crudrestdemo.model.getresponse.Product(
							characteristics.get(z).getCharacteristicsId(), characteristics.get(z).getArName(),
							characteristics.get(z).getFixAmount()));
					enProducts.add(new com.mahmoudimam.crudrestdemo.model.getresponse.Product(
							characteristics.get(z).getCharacteristicsId(), characteristics.get(z).getEnName(),
							characteristics.get(z).getFixAmount()));

					arProdList.setProduct(arProducts);
					enProdList.setProduct(enProducts);
				}
				arMerchants.add(new Merchant(charities.get(j).getCharityId(), charities.get(j).getArName(),
						charities.get(j).getMerCode(), arProdList));
				enMerchants.add(new Merchant(charities.get(j).getCharityId(), charities.get(j).getEnName(),
						charities.get(j).getMerCode(), enProdList));
			}
			arMaincats.add(new Maincat(categories.get(i).getCategoryId(), categories.get(i).getArName(),
					categories.get(i).getEnabled().toString(), arMerchants));
			enMaincats.add(new Maincat(categories.get(i).getCategoryId(), categories.get(i).getEnName(),
					categories.get(i).getEnabled().toString(), enMerchants));
		}
		merlists.add(new Merlist("ar", arMaincats));
		merlists.add(new Merlist("en", enMaincats));

		return new Donations(merlists);
	}

}
