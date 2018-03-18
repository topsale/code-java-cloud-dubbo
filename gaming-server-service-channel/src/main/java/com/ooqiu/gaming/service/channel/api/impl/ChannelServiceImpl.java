package com.ooqiu.gaming.service.channel.api.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.service.channel.api.ChannelService;
import com.ooqiu.gaming.service.channel.mapper.ChannelMapper;
import com.ooqiu.gaming.service.redis.api.RedisService;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqui.gaming.server.commons.utils.MapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_CHANNEL)
public class ChannelServiceImpl implements ChannelService {
    private static final Logger logger = LoggerFactory.getLogger(ChannelServiceImpl.class);

    @Autowired
    private ChannelMapper channelMapper;

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_REDIS)
    private RedisService redisService;

    @Override
    public List<Channel> selectAll() {
        try {
            // 先判断是否存在缓存
            String json = (String) redisService.get("channelList");

            // 存在缓存
            if (StringUtils.isNotBlank(json)) {
                logger.info("获取频道缓存：{}", json);
                return MapperUtils.json2list(json, Channel.class);
            }

            // 不存在缓存
            else {
                // 从数据库查询
                List<Channel> channels = channelMapper.selectAll();
                redisService.set("channelList", MapperUtils.obj2json(channels), 3600);
                logger.info("设置频道缓存：{}", channels);
                return channels;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
