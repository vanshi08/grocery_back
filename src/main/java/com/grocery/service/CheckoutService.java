package com.grocery.service;
import com.grocery.dto.PaymentInfo;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
	PaymentIntent createPaymentIntent(PaymentInfo paymentInfo)throws StripeException;

}
