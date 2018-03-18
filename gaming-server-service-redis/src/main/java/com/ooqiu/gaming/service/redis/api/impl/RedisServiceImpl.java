package com.ooqiu.gaming.service.redis.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.service.redis.api.RedisService;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_REDIS)
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, int seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }
}
