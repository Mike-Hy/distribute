package com.michael.orderservice.service;

import com.michael.api.CreditApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("credit-service")
public interface CreditService extends CreditApi {
}
