package com.michael.orderservice.service;

import com.michael.api.WareHouseApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("warehouse-service")
public interface WareHouseService extends WareHouseApi {
}
