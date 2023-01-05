package com.grocery.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.entity.Cart;
import com.grocery.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Optional<Cart> viewCart(int cartId) {
		Optional<Cart> opt = cartRepository.findById(cartId);
		if(opt.isEmpty()) {
			log.error("cart is empty");
		}
		return cartRepository.findById(cartId);
	}

	@Override
	public String removeCart(int cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);
		if(!cart.isPresent()) {
			log.error("category not found");
		}
		cartRepository.deleteById(cartId);
		return "cart deleted";
	}


}
