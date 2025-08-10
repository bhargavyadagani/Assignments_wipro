package com.example.ecommerce.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.ecommerce.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public boolean isAvailable(String itemId) {
        // Dummy logic: item "ITEM002" is out of stock
        return !"ITEM002".equalsIgnoreCase(itemId);
    }
}
