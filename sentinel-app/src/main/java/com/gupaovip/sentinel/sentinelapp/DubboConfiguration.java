package com.gupaovip.sentinel.sentinelapp;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:DubboConfiguration
 * Package:com.gupaovip.sentinel.sentinelapp
 * description
 * Created by zhangbin on 2019/8/13.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/13 17:07
 */
@Configuration
@DubboComponentScan({"com.gupaovip.sentinel.sentinelapp"})
public class DubboConfiguration {

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setOwner("zhangbin");
        applicationConfig.setName("Sentinel-web");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.5.179:2181");
        return registryConfig;
    }
}
