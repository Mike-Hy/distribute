package com.michael.impl;

import com.michael.api.WareHouseApi;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WareHouseApiImpl
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/6 10:57
 **/
@RestController
public class WareHouseApiImpl implements WareHouseApi {

        @Override
        public void ship(@RequestParam("productId") String productId) {
                System.out.println("商品："+productId+" 已经发货");
        }
}