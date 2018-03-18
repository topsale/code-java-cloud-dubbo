package com.ooqiu.gaming.server.api.controller.v1;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Lists;
import com.ooqiu.gaming.server.api.dto.BaseResult;
import com.ooqiu.gaming.server.api.dto.ChannelDTO;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.service.channel.api.ChannelService;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 频道接口
 * <p>Title: ChannelControllerV1</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/7 10:42
 */
@RestController
@RequestMapping(value = "${rest.path.api.v1}/channel")
public class ChannelControllerV1 {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_CHANNEL)
    private ChannelService channelService;

    /**
     * 获取全部频道
     * @return
     */
    @ApiOperation(value = "获取频道列表", notes = "获取全部频道列表")
    @RequestMapping(value = "data", method = RequestMethod.GET)
    public BaseResult data() {
        List<ChannelDTO> data = Lists.newArrayList();
        List<Channel> channels = channelService.selectAll();

        for (Channel channel : channels) {
            ChannelDTO dto = new ChannelDTO();
            BeanUtils.copyProperties(channel, dto);
            data.add(dto);
        }

        Channel channel = new Channel();

        return BaseResult.success(data);
    }
}
