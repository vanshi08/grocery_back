package com.grocery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

	Optional<ProductCategory> findByCategoryName(String categoryName);

	void deleteByCategoryName(String categoryName);

}
