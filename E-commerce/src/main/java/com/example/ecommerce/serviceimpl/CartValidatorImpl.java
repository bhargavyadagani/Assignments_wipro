package com.example.ecommerce.serviceimpl;

import org.springframework.stereotype.Component;

import com.example.ecommerce.service.CartValidator;

@Component
public class CartValidatorImpl implements CartValidator {
    @Override
    public boolean validateCart(String cartId) {
        // Dummy: CART001 is valid, others invalid
        return "CART001".equalsIgnoreCase(cartId);
    }
}
