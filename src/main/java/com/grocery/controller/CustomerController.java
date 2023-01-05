package com.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.entity.Cart;
import com.grocery.entity.Product;
import com.grocery.entity.ProductCategory;
import com.grocery.service.CartService;
import com.grocery.service.ProductCategoryService;
import com.grocery.service.ProductService;
import com.grocery.service.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@Validated
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductCategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/getproduct/{productName}")
	public Optional<Product> searchProductByName(@PathVariable String productName) {
		return productService.searchProductByName(productName);
	}
	
	@GetMapping("/getcategory/{categoryName}")
	public Optional<ProductCategory> viewProductCategoryByName(@PathVariable String categoryName) {
		return categoryService.viewProductCategoryByName(categoryName);
	}
	
	@GetMapping("/getcart/{cartId}")
	public Optional<Cart> viewCart(@PathVariable int cartId) {
		return cartService.viewCart(cartId);
	}
	
	
	@DeleteMapping("/deletecart/{cartId}")
	public ResponseEntity<String> removeCart(@PathVariable("cartId") int cartId){
	     	cartService.removeCart(cartId);
			return new ResponseEntity<>("Cart Removed", HttpStatus.OK);	
	}
	
	@GetMapping("/allproducts")
	public List<Product> getProductByName() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/allcategories")
	public List<ProductCategory> getAllProductCategories() {
		return categoryService.getAllProductCategories();
	}
	
}
