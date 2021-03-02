package com.michael.impl;

import com.michael.api.CreditApi;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CreditApiImpl
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/5 15:46
 **/
@RestController
public class CreditApiImpl implements CreditApi {

        @Override
        public String add(@RequestParam("userId") Long userId,@RequestParam("credit") Long credit) {
                System.out.println("对用户【userId=" + userId + "】增加积分：" + credit);
                return "{'msg': 'success'}";
        }
}