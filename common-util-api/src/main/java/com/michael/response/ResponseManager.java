package com.michael.response;

import lombok.Data;

/**
 * @ClassName ResponseManager
 * @Description 结果封装类
 * @Author Michael.Ng
 * @Date 2021/2/20 16:41
 **/
@Data
public class ResponseManager<T> {

        /**
         * 返回结果
         */
        public  T result;

        /**
         * 000:成功
         * 001：失败
         */
        public  String  code;

}