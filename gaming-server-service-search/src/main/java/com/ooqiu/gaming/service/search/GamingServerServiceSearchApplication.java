package com.ooqiu.gaming.service.search;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ooqiu.gaming.service.search.mapper")
public class GamingServerServiceSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceSearchApplication.class, args);
        Main.main(args);
    }
}
