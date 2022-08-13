package com.rajni.orderservice.rest;

import com.rajni.ecommers.common.model.response.ItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class InventoryServiceClient {
    private static final String SERVICE_URL = "http://inventory-service:8070/inventory";

    private RestTemplate restTemplate;

    public ItemResponse getItem(int itemId) {
        final ResponseEntity<ItemResponse> response = restTemplate.getForEntity(SERVICE_URL + "/get-item/" + itemId, ItemResponse.class);
        return response.getBody();
    }
}
