package com.michael.zullgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName GrayReleaseConfigManager
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/18 21:09
 **/
@Component
@Configuration
@EnableScheduling
public class GrayReleaseConfigManager {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        private Map<String,GrayReleaseConfig> map = new ConcurrentHashMap<>();


        @Scheduled(fixedRate = 3000)
        private void refreshRoute(){
//                System.out.println("定时任务启动");
                List<GrayReleaseConfig> releaseConfigList = jdbcTemplate.query("select * from gray_release_config", new BeanPropertyRowMapper<GrayReleaseConfig>(GrayReleaseConfig.class));
                for(GrayReleaseConfig config : releaseConfigList){
//                        System.out.println(config.toString());
                        map.put(config.getPath(),config);
                }
        }

        public Map<String,GrayReleaseConfig> getGrayReleaseConfig(){
                return map;
        }

}