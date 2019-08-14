package com.gupaovip.sentinel.sentinelapp;

import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentinelAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelAppApplication.class, args);
    }
}
