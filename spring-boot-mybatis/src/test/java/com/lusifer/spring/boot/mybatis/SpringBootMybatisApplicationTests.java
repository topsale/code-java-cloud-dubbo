package com.lusifer.spring.boot.mybatis;

import com.lusifer.spring.boot.mybatis.domain.Channel;
import com.lusifer.spring.boot.mybatis.mapper.ChannelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

	@Autowired
	private ChannelMapper channelMapper;

	@Test
	public void contextLoads() {
		List<Channel> channels = channelMapper.selectAll();
		System.out.println(channels);
	}

}
