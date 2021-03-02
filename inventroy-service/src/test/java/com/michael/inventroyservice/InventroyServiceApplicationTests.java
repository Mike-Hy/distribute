package com.michael.inventroyservice;

import com.alibaba.fastjson.JSON;
import com.michael.config.RedisUtils;
import com.michael.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = InventroyServiceApplication.class)
class InventroyServiceApplicationTests {


        @Test
        void contextLoads() {
                User user = new User("michael", 20, "china");
                RedisUtils.hset("user","michael",JSON.toJSONString(user));
                String result = RedisUtils.hget("user","michael");
                System.out.println(result);
        }

}
