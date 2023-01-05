package com.grocery.service;

import java.util.List;
import java.util.Optional;

import com.grocery.dto.ProductCategoryDTO;
import com.grocery.entity.ProductCategory;

public interface ProductCategoryService {
	
	public ProductCategory addProductCategory(ProductCategoryDTO categorydto);

	public Optional<ProductCategory> viewProductCategory(int categoryId);
	
	public Optional<ProductCategory> viewProductCategoryByName(String categoryName);

	public List<ProductCategory> getAllProductCategories();
	
	public String removeProductCategory(int categoryId);

	public String removeProductCategoryByName(String categoryName);
	
}
