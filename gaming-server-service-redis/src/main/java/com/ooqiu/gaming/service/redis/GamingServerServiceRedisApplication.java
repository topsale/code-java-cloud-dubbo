package com.ooqiu.gaming.service.redis;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamingServerServiceRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceRedisApplication.class, args);
        Main.main(args);
    }
}
