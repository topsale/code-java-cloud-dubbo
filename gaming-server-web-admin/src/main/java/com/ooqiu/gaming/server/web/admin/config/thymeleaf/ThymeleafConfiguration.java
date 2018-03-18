package com.ooqiu.gaming.server.web.admin.config.thymeleaf;

import com.ooqiu.gaming.server.web.admin.config.thymeleaf.dialect.ThSysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Thymeleaf 配置
 * <p>Title: ThymeleafConfiguration</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/5 10:02
 */
@Configuration
public class ThymeleafConfiguration {
    @Bean
    public ThSysDialect thSysDialect() {
        return new ThSysDialect();
    }
}
