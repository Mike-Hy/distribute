package com.michael.orderservice.controller;

import com.michael.orderservice.service.CreditService;
import com.michael.orderservice.service.InventoryService;
import com.michael.orderservice.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/6 11:55
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

        @Autowired
        CreditService creditService;

        @Autowired
        InventoryService inventoryService;

        @Autowired
        WareHouseService wareHouseService;

        @RequestMapping(value = "create",method = RequestMethod.GET)
        public String createOrder(@RequestParam("productId") String productId,
                                  @RequestParam("stock") int stock,
                                  @RequestParam("userId") Long userId,
                                  @RequestParam("credit") Long credit,
                                  @RequestParam("orderSn") String orderSn){
                System.out.println("=======创建订单========");
                inventoryService.deduction(orderSn,productId, stock);
                creditService.add(userId, credit);
                wareHouseService.ship(productId);
                return "success";
        }

}