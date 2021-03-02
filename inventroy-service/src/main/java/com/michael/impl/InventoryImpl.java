package com.michael.impl;

import com.michael.annotation.Idempotence;
import com.michael.constant.Constant;
import com.michael.inventoryapi.api.InventoryApi;
import com.michael.response.ResponseManager;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName InventoryImpl
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/6 10:43
 **/
@RestController
public class InventoryImpl implements InventoryApi {

        /**
         * 扣减库存
         * @param productId
         * @param stock
         * @return
         */
        @Idempotence
        @Override
        public ResponseManager<Boolean> deduction(@RequestParam("orderSn") String orderSn,@RequestParam("productId") String productId, @RequestParam("num") int stock) {
                System.out.println("订单号："+orderSn+", 扣减商品：productId = " + productId + ", 库存：stock = " + stock);
                ResponseManager<Boolean> result = new ResponseManager<Boolean>();
                result.setResult(true);
                result.setCode(Constant.SUCCESS);
                return  result;
        }
}