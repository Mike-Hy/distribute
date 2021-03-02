package com.michael.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName CreditApi
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/5 15:31
 **/
@RequestMapping("/credit")
public interface CreditApi {

        @RequestMapping(value = "/add",method = RequestMethod.POST)
        String add(@RequestParam("userId") Long userId, @RequestParam("credit") Long credit);
}