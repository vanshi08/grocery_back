package com.grocery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

}
