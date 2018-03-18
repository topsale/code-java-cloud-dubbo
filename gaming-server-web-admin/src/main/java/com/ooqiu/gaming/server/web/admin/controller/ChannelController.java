package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Lists;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.server.web.admin.dto.TreeView;
import com.ooqiu.gaming.service.admin.api.ChannelService;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "channel")
public class ChannelController {
    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private ChannelService channelService;

    /**
     * 跳转到频道列表页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        // 排序后的集合
        List<Channel> targetList = Lists.newArrayList();
        List<Channel> sourceList = channelService.selectAll();

        sortChannelList(targetList, sourceList);

        model.addAttribute("channels", targetList);
        return "modules/channel/list";
    }

    /**
     * 跳转表单页面
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model) {
        return "modules/channel/form";
    }

    /**
     * 保存频道
     * @param channel
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Channel channel) {
        int result = channelService.save(channel);
        return "redirect:/channel/list";
    }

    /**
     * 前端树结构
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree")
    public List<TreeView> treeData(String pid) {
        List<TreeView> list = Lists.newArrayList();

        // 处理首次查询的参数
        if (StringUtils.isBlank(pid) || "#".equals(pid)) {
            pid = "0";
        }

        List<Channel> channels = channelService.selectByPid(Long.parseLong(pid));
        for (Channel channel : channels) {
            TreeView treeView = new TreeView();
            treeView.setId(String.valueOf(channel.getId()));
            treeView.setIcon("");
            treeView.setText(channel.getName());
            treeView.setChildren("0".equals(channel.getIsParent()));
            list.add(treeView);
        }

        return list;
    }

    /**
     * 频道排序，用于配合前端属性表格展示
     * @param targetList 排序后的集合
     * @param sourceList 数据源的集合
     */
    private void sortChannelList(List<Channel> targetList, List<Channel> sourceList) {
        for (Channel channel : sourceList) {
            // 判断是否为父节点
            if ("0".equals(channel.getIsParent())) {
                targetList.add(channel);
                // 判断是否有子节点
                for (Channel subChannel : sourceList) {
                    if (subChannel.getPid().equals(channel.getId())) {
                        targetList.add(subChannel);
                    }
                }
            }
        }
    }
}
