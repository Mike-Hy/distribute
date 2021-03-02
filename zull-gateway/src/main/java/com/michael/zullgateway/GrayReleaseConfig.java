package com.michael.zullgateway;

import lombok.Data;

/**
 * @ClassName GrayReleaseConfig
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/18 21:07
 **/
@Data
public class GrayReleaseConfig {

        private int id;
        private String serviceId;
        private String path;
        private int enableGrayRelease;
}