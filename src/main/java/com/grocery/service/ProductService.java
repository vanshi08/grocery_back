package com.grocery.service;

import java.util.List;
import java.util.Optional;

import com.grocery.dto.ProductDTO;
import com.grocery.entity.Product;

public interface ProductService {
	
	public Product addProduct(ProductDTO productdto);
	
	public Optional<Product> searchProduct(int productId);
	
	public Optional<Product> searchProductByName(String productName);
	
	public String removeProduct(int productId);
	
	public String removeProductByName(String productName);
	
	public Product updateProduct(ProductDTO productdto, int productId);
		
	public List<Product> getAllProducts();

}
