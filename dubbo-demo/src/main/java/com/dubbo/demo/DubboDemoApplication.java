package com.dubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/10 11:10
 */

@SpringBootApplication
@EnableDiscoveryClient
public class DubboDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboDemoApplication.class, args);
    }


}
