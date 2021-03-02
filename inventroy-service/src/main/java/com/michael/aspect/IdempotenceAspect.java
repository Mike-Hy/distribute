package com.michael.aspect;

import com.michael.config.RedisUtils;
import com.michael.constant.Constant;
import com.michael.response.ResponseManager;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @ClassName IdempotenceAspect
 * @Description 定义切面，获取有Idempotence注解的方法返回结果
 * @Author Michael.Ng
 * @Date 2021/2/20 16:31
 **/
@Aspect
@Component
public class IdempotenceAspect {

        @AfterReturning(pointcut = "@annotation(com.michael.annotation.Idempotence)",returning="returnValue")
        public void  afterReturn(JoinPoint joinPoint,Object returnValue){
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                String[] parameterNames = signature.getParameterNames();

                int productIdIndex = ArrayUtils.indexOf(parameterNames, Constant.PRODUCT_ID);
                int orderSnIndex = ArrayUtils.indexOf(parameterNames, Constant.ORDER_SN);
                int stockIndex = ArrayUtils.indexOf(parameterNames, Constant.STOCK);
                if (productIdIndex == -1 || stockIndex == -1 || orderSnIndex == -1) {
                        return ;
                }
                Object[] args = joinPoint.getArgs();
                String productId = String.valueOf(args[productIdIndex]);
                String orderSn = String.valueOf(args[orderSnIndex]);
                String stock = String.valueOf(args[stockIndex]);
                if(StringUtils.isEmpty(productId) || StringUtils.isEmpty(orderSn) || StringUtils.isEmpty(stock)){
                        return;
                }
                String key = productId +":"+orderSn+":"+stock;
                ResponseManager result = (ResponseManager) returnValue;
                //方法执行成功
                if(Constant.SUCCESS.equals(result.getCode())){
                        if(StringUtils.isEmpty(RedisUtils.get(key))){
                                RedisUtils.set(key,stock,6*1000);
                                System.out.println("订单号:"+orderSn+", 商品："+productId+" 库存 ："+RedisUtils.get(key));
                        }else{
                                //执行数据库回滚操作
                                System.out.println("执行库存回滚操作");
                                //如果执行数据回滚操作失败，则定时重试回滚操作2次，还是失败，邮件通知人工修改库存
                        }
                }
        }
}