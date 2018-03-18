package com.ooqiu.gaming.service.admin;

import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.service.admin.mapper.ChannelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamingServerServiceAdminApplicationTests {
    @Autowired
    private ChannelMapper channelMapper;

    @Test
    public void testChannelSelectAll() {
        List<Channel> channels = channelMapper.selectAll();
        System.out.println(channels);
    }
}
