package com.ooqiu.gaming.server.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GamingServerWebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerWebAdminApplication.class, args);
    }
}
