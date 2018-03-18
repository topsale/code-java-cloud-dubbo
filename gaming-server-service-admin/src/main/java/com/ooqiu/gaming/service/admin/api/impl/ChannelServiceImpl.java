package com.ooqiu.gaming.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.service.admin.api.ChannelService;
import com.ooqiu.gaming.service.admin.mapper.ChannelMapper;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqui.gaming.server.commons.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 频道接口实现
 * <p>Title: ChannelServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/2/2 10:42
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public List<Channel> selectAll() {
        return channelMapper.selectAll();
    }

    @Override
    public List<Channel> selectByPid(Long pid) {
        Example example = new Example(Channel.class);
        example.createCriteria().andEqualTo("pid", pid);
        return channelMapper.selectByExample(example);
    }

    @Override
    public Channel getById(Long id) {
        return null;
    }

    @Override
    public int save(Channel channel) {
        channel.setId(IDUtils.genId());
        channel.setIsParent("1");
        channel.setCreateDate(new Date());
        channel.setUpdateDate(new Date());

        // 判断是否为父级频道
        if (channel.getPid() == null || channel.getPid() == 0L) {
            channel.setPid(0L);
            channel.setIsParent("0");
        }

        return channelMapper.insert(channel);
    }
}
