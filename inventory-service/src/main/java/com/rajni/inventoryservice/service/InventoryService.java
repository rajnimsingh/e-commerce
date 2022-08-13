package com.rajni.inventoryservice.service;

import com.rajni.inventoryservice.model.InventoryException;

public interface InventoryService {

    double getPrice(final int itemId) throws InventoryException;
}
