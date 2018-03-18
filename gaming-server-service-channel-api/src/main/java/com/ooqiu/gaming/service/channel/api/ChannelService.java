package com.ooqiu.gaming.service.channel.api;

import com.ooqiu.gaming.server.domain.Channel;

import java.util.List;

/**
 * 频道接口
 * <p>Title: ChannelService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/7 9:34
 */
public interface ChannelService {
    /**
     * 查询全部频道
     *
     * @return
     */
    public List<Channel> selectAll();
}
