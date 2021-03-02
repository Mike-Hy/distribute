package com.michael.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/warehouse")
public interface WareHouseApi {

        @RequestMapping("/ship")
        public void ship(@RequestParam("productId") String productId);
}
