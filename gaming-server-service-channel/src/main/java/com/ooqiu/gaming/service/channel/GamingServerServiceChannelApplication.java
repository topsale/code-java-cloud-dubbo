package com.ooqiu.gaming.service.channel;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ooqiu.gaming.service.channel.mapper")
public class GamingServerServiceChannelApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceChannelApplication.class, args);
        Main.main(args);
    }
}
