package com.ooqiu.gaming.service.admin.api;

import com.ooqiu.gaming.server.domain.Channel;

import java.util.List;

/**
 * 频道接口
 * <p>Title: ChannelService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/2/2 10:40
 */
public interface ChannelService {
    /**
     * 查询所有频道
     * @return
     */
    public List<Channel> selectAll();

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    public List<Channel> selectByPid(Long pid);

    /**
     * 根据 ID 查询频道
     * @param id
     * @return
     */
    public Channel getById(Long id);

    /**
     * 保存频道
     * @param channel
     * @return
     */
    public int save(Channel channel);
}
