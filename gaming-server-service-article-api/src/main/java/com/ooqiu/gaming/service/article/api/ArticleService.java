package com.ooqiu.gaming.service.article.api;

import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Article;

/**
 * 文章接口
 * <p>Title: ArticleService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/7 10:17
 */
public interface ArticleService {
    /**
     * 查询全部文章
     *
     * @param pageNum  页码
     * @param pageSize 笔数
     * @return
     */
    public PageInfo<Article> selectAll(int pageNum, int pageSize);

    /**
     * 根据频道查询文章
     *
     * @param pageNum
     * @param pageSize
     * @param channelId
     * @return
     */
    public PageInfo<Article> selectByChannelId(int pageNum, int pageSize, long channelId);

    /**
     * 根据类别查询文章
     *
     * @param pageNum
     * @param pageSize
     * @param type     文章类别：1/文章，2/视频
     * @return
     */
    public PageInfo<Article> selectByType(int pageNum, int pageSize, String type);
}
