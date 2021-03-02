package com.michael.interceptor;

import com.michael.annotation.Idempotence;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName IdempotenceInterceptor
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/20 15:31
 **/
public class IdempotenceInterceptor implements HandlerInterceptor {

        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable ModelAndView modelAndView) throws Exception {

                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Method method = handlerMethod.getMethod();
                Idempotence annotation = method.getAnnotation(Idempotence.class);



//                if(annotation != null){
//
//                        method.invoke()
//                }

        }


}