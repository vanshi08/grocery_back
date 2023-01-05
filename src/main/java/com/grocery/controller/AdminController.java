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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.dto.ProductCategoryDTO;
import com.grocery.dto.ProductDTO;
import com.grocery.entity.Product;
import com.grocery.entity.ProductCategory;
import com.grocery.service.CartService;
import com.grocery.service.ProductCategoryService;
import com.grocery.service.ProductService;
import com.grocery.service.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@Validated
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductCategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addproducts")
	public ResponseEntity<Integer> addProduct(@RequestBody ProductDTO productdto) {
		Product product = productService.addProduct(productdto);
		return new ResponseEntity<>(product.getProductId(),HttpStatus.OK);
	}
	
	@PostMapping("/addproductcategory")
	public ResponseEntity<Integer> addProductCategory(@RequestBody ProductCategoryDTO categorydto) {
		ProductCategory category = categoryService.addProductCategory(categorydto);
		return new ResponseEntity<>(category.getCategoryId(),HttpStatus.OK);
	}
	
	@GetMapping("/getproductbyid/{productId}")
	public Optional<Product> searchProduct(@PathVariable int productId) {
		return productService.searchProduct(productId);
	}
	
	@GetMapping("/getproduct/{productName}")
	public Optional<Product> searchProductByName(@PathVariable String productName) {
		return productService.searchProductByName(productName);
	}
	
	@GetMapping("/getcategory/{categoryId}")
	public Optional<ProductCategory> viewProductCategory(@PathVariable int categoryId) {
		return categoryService.viewProductCategory(categoryId);
	}
	
	@GetMapping("/getcategory/{categoryName}")
	public Optional<ProductCategory> viewProductCategoryByName(@PathVariable String categoryName) {
		return categoryService.viewProductCategoryByName(categoryName);
	}
	
	@GetMapping("/allproducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/allcategories")
	public List<ProductCategory> getAllProductCategories() {
		return categoryService.getAllProductCategories();
	}
	
	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<String> removeProduct(@PathVariable("productId") int productId){
	     	productService.removeProduct(productId);
			return new ResponseEntity<>("Product Removed", HttpStatus.OK);	
	}
	
	@DeleteMapping("/deleteproductbyname/{productName}")
	public ResponseEntity<String> removeProductByName(@PathVariable("productName") String productName){
	     	productService.removeProductByName(productName);
			return new ResponseEntity<>("Product Removed", HttpStatus.OK);	
	}
	
	@DeleteMapping("/deletecategorybyname/{categoryName}")
	public ResponseEntity<String> removeProductCategoryByName(@PathVariable("categoryName") String categoryName){
	     	categoryService.removeProductCategoryByName(categoryName);
			return new ResponseEntity<>("Category Removed", HttpStatus.OK);	
	}
	
	@DeleteMapping("/deletecategory/{categoryId}")
	public ResponseEntity<String> removeProductCategory(@PathVariable("categoryId") int categoryId){
	     	categoryService.removeProductCategory(categoryId);
			return new ResponseEntity<>("Product Removed", HttpStatus.OK);	
	}
	
	@PutMapping("/editproduct/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDTO productdto) {
		Product editProduct = productService.updateProduct(productdto,productId);
		return ResponseEntity.ok().body(editProduct);
	}
	
}
