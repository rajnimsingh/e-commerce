package com.example.inventoryservice.service;

import com.example.inventoryservice.model.InventoryException;

public interface InventoryService {

    double getPrice(final int itemId) throws InventoryException;
}
