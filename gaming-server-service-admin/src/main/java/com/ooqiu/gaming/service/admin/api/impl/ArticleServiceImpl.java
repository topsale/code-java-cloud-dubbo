package com.ooqiu.gaming.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.service.admin.api.ArticleService;
import com.ooqiu.gaming.service.admin.mapper.ArticleMapper;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqui.gaming.server.commons.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * 文章管理
 * <p>Title: ArticleServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/3 14:38
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int save(Article article) {
        article.setId(IDUtils.genId());
        article.setCreateDate(new Date());
        article.setUpdateDate(new Date());
        return articleMapper.insert(article);
    }

    @Override
    public PageInfo<Article> page(int page, int pageSize) {
        Example example = new Example(Article.class);
        PageHelper.startPage(page, pageSize);
        PageInfo<Article> pageInfo = new PageInfo<>(articleMapper.selectByExample(example));
        return pageInfo;
    }
}
