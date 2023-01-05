package com.grocery.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.dto.ProductCategoryDTO;
import com.grocery.entity.ProductCategory;
import com.grocery.repository.ProductCategoryRepository;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductCategoryRepository categoryRepository;
	
	@Override
	public Optional<ProductCategory> viewProductCategory(int categoryId) {
		Optional<ProductCategory> opt = categoryRepository.findById(categoryId);
		if(opt.isEmpty()) {
			log.error("category not found");
		}
		return categoryRepository.findById(categoryId);
	}

	@Override
	public Optional<ProductCategory> viewProductCategoryByName(String categoryName) {
		Optional<ProductCategory> opt = categoryRepository.findByCategoryName(categoryName);
		if(opt.isEmpty()) {
			log.error("category not found");
		}
		return categoryRepository.findByCategoryName(categoryName);
	}

	@Override
	public ProductCategory addProductCategory(ProductCategoryDTO categorydto) {
		Optional<ProductCategory> opt = categoryRepository.findByCategoryName(categorydto.getCategoryName());
		if(opt.isPresent()) {
			log.error("category exists");
		}
		ProductCategory category = new ProductCategory();
		category.setCategoryName(categorydto.getCategoryName());
		return categoryRepository.save(category);
	}

	@Override
	public String removeProductCategory(int categoryId) {
		Optional<ProductCategory> category = categoryRepository.findById(categoryId);
		if(!category.isPresent()) {
			log.error("category not found");
		}
		categoryRepository.deleteById(categoryId);
		return "category deleted";
	}

	@Override
	public List<ProductCategory> getAllProductCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public String removeProductCategoryByName(String categoryName) {
		Optional<ProductCategory> category = categoryRepository.findByCategoryName(categoryName);
		if(!category.isPresent()) {
			log.error("category not found");
		}
		categoryRepository.deleteByCategoryName(categoryName);
		return "category deleted";
	}


}
