package com.michael.zullgateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName GrayReleaseFilter
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/18 21:18
 **/
@Configuration
public class GrayReleaseFilter extends ZuulFilter {

        @Resource
        private GrayReleaseConfigManager grayReleaseConfigManager;

        @Override
        public String filterType() {
                return PRE_TYPE;
        }

        @Override
        public int filterOrder() {
                return PRE_DECORATION_FILTER_ORDER-1;
        }

        @Override
        public boolean shouldFilter() {
                RequestContext currentContext = RequestContext.getCurrentContext();
                HttpServletRequest request = currentContext.getRequest();
                String requestURI = request.getRequestURI();

                Map<String, GrayReleaseConfig> grayReleaseConfig = grayReleaseConfigManager.getGrayReleaseConfig();
                for(String path :grayReleaseConfig.keySet()){
                        if(requestURI.contains(path)){
                                GrayReleaseConfig config = grayReleaseConfig.get(path);
                                if(config.getEnableGrayRelease() == 1){
                                        System.out.println("============启用灰度发布功能==============");
                                        return true;
                                }
                        }
                }

                System.out.println("==========不启用灰度发布功能=============");

                return false;
        }

        @Override
        public Object run() throws ZuulException {

                RequestContext currentContext = RequestContext.getCurrentContext();
                HttpServletRequest request = currentContext.getRequest();
                String gray = request.getParameter("gray");
                if(gray.equals("true")){
                        RibbonFilterContextHolder.getCurrentContext().add("version", "new");
                }else{
                        RibbonFilterContextHolder.getCurrentContext().add("version", "current");
                }

                return null;
        }
}