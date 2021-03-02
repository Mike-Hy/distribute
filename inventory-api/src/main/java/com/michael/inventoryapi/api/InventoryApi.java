package com.michael.inventoryapi.api;

import com.michael.response.ResponseManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/inventory")
public interface InventoryApi {

        /**
         * 扣减库存
         * @param productId
         * @param stock
         */
        @RequestMapping(value = "/deduction",method = RequestMethod.POST)
         ResponseManager<Boolean> deduction(@RequestParam("orderSn") String orderSn,@RequestParam("productId") String productId, @RequestParam("num") int stock);

}
