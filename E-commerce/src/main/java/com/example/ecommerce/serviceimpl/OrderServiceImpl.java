package com.example.ecommerce.serviceimpl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.mode.Order;
import com.example.ecommerce.service.CartValidator;
import com.example.ecommerce.service.InventoryService;
import com.example.ecommerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartValidator cartValidator;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public String checkout(String cartId) {
        if (!cartValidator.validateCart(cartId)) {
            return "Cart is invalid";
        }

        Order order = new Order();
        order.setOrderId(cartId);
        order.setItemIds(Arrays.asList("ITEM001", "ITEM002"));

        for (String itemId : order.getItemIds()) {
            if (!inventoryService.isAvailable(itemId)) {
                return "Item out of stock";
            }
        }
        return "Checkout successful for " + cartId;
    }
}
