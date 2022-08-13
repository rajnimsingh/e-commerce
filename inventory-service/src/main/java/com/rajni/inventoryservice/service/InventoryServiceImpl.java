package com.rajni.inventoryservice.service;

import com.rajni.inventoryservice.model.InventoryException;
import com.rajni.ecommers.common.utils.EcommerceServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public double getPrice(int itemId) throws InventoryException {
        log.info("Inventory Service checking the itemID, {}", itemId);
        if(itemId < 500) {
            return Math.random() * 1000;
        }
        log.error("Inventory Service failed due to item {} unavailability", itemId);
        throw new InventoryException(EcommerceServiceConstants.ITEM_UNAVAILABLE);
    }
}
