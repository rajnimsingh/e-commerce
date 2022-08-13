package com.example.inventoryservice.model;

public class InventoryException extends Exception {
    public InventoryException() {
        super();
    }

    public InventoryException(String message) {
        super(message);
    }
}
