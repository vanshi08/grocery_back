package com.grocery.service;

import java.util.Optional;

import com.grocery.entity.Cart;

public interface CartService {
	public Optional<Cart> viewCart(int cartId);
	
	public String removeCart(int cartId);
	
}
