package com.grocery.dto;

public class ProductCategoryDTO {

	@SuppressWarnings("unused")
	private int categoryId;
	
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
