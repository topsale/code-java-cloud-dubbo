package com.ooqiu.gaming.server.web.admin.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ooqiu.gaming.service.admin.api.DictService;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import org.springframework.stereotype.Component;

/**
 * Dubbo 上下文
 * <p>Title: DubboContextUtils</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/5 10:40
 */
@Component
public class DubboContextUtils {
    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private DictService dictService;

    public DictService getDictService() {
        return dictService;
    }
}
