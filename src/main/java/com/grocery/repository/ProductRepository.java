package com.grocery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	Optional<Product> findByProductName(String productName);

	void deleteByProductName(String productName);


}
