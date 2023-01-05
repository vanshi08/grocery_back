package com.grocery.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.grocery.dto.PaymentInfo;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class CheckoutServiceImpl implements CheckoutService{
	public CheckoutServiceImpl(@Value("${stripe.key.secret}")String secretKey) {
		Stripe.apiKey=secretKey;
	}

	@Override
	public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {
		// TODO Auto-generated method stub
		List<String>paymentMethodTypes=new ArrayList<>();
		paymentMethodTypes.add("card");
		Map<String, Object> params=new HashMap<>();
		params.put("amount", paymentInfo.getAmount());
		params.put("currency", paymentInfo.getCurrency());
		params.put("payment_method_types", paymentMethodTypes);
		return PaymentIntent.create(params);
	}
}
