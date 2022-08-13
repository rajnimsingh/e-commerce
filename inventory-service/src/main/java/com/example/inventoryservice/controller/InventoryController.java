package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.InventoryException;
import com.example.inventoryservice.service.InventoryService;
import com.rajni.ecommers.common.model.Error;
import com.rajni.ecommers.common.model.response.ItemResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {
    private static final Logger LOG = LoggerFactory.getLogger(InventoryController.class);

    private final InventoryService inventoryService;

    @GetMapping("/get-item/{itemId}")
    public ItemResponse getItem(@PathVariable("itemId") final int itemId) {
        try {
            LOG.info("Fetching details for the Item, {}", itemId);
            return ItemResponse.builder()
                    .itemPrice(inventoryService.getPrice(itemId))
                    .available(true)
                    .build();
        } catch (InventoryException e) {
            LOG.error("Fetching details for the Item fails, {}", itemId, e);
            return ItemResponse.builder()
                    .available(false)
                    .error(Error.builder().message(e.getMessage()).build())
                    .build();
        }
    }
}
