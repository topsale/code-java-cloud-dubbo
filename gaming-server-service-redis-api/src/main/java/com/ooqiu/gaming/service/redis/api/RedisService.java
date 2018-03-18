package com.ooqiu.gaming.service.redis.api;

public interface RedisService {
    public Object get(String key);

    public void set(String key, Object value);

    /**
     * 带缓存失效时间
     *
     * @param key
     * @param value
     * @param seconds 失效时间/秒
     */
    public void set(String key, Object value, int seconds);
}
