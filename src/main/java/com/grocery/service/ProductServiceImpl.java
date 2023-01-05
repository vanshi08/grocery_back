package com.grocery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.dto.ProductDTO;
import com.grocery.entity.Product;
import com.grocery.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductServiceImpl implements ProductService{
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(ProductDTO productdto) {
		Optional<Product> opt = productRepository.findByProductName(productdto.getProductName());
		if(opt.isPresent()) {
			log.error("product already exists");
		}
		Product product = new Product();
		product.setProductName(productdto.getProductName());
		product.setInStock(productdto.isInStock());
		product.setProductPrice(productdto.getProductPrice());
		product.setProductNumber(productdto.getProductNumber());
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> searchProduct(int productId) {
		Optional<Product> opt = productRepository.findById(productId);
		if(opt.isEmpty()) {
			log.error("product not found");
		}
		return productRepository.findById(productId);
	}

	@Override
	public Optional<Product> searchProductByName(String productName) {
		Optional<Product> opt = productRepository.findByProductName(productName);
		if(opt.isEmpty()) {
			log.error("product not found");
		}
		return productRepository.findByProductName(productName);
	}

	@Override
	public String removeProduct(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		if(!product.isPresent()) {
			log.error("product does not exist");
		}
		productRepository.deleteById(productId);
		return "product deleted";
	}

	@Override
	public String removeProductByName(String productName) {
		Optional<Product> product = productRepository.findByProductName(productName);
		if(!product.isPresent()) {
			log.error("product does not exist");
		}
		productRepository.deleteByProductName(productName);
		return "product deleted";
	}

	@SuppressWarnings("deprecation")
	@Override
	public Product updateProduct(ProductDTO productdto, int productId) {
		Optional<Product> opt = productRepository.findById(productId);
		if(opt.isEmpty()) {
			log.error("product not found");
		}
		Product product = productRepository.getById(productId);
		product.setProductName(productdto.getProductName());
		product.setInStock(productdto.isInStock());
		
		return productRepository.save(product);
		
	}



}
