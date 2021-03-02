package com.michael.orderservice.service;

import com.michael.inventoryapi.api.InventoryApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("inventroy-service")
public interface InventoryService extends InventoryApi {

}
