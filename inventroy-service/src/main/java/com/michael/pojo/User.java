package com.michael.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/3/2 9:36
 **/
@Data
@AllArgsConstructor
public class User {

        public String name;

        public int age;

        public String address;
}