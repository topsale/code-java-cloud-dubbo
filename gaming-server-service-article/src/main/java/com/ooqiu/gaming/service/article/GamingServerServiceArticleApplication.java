package com.ooqiu.gaming.service.article;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ooqiu.gaming.service.article.mapper")
public class GamingServerServiceArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceArticleApplication.class, args);
        Main.main(args);
    }
}
