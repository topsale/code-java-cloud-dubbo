package com.ooqiu.gaming.service.admin.api;

import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Article;

/**
 * 文章管理
 * <p>Title: ArticleService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/3 14:37
 */
public interface ArticleService {
    /**
     * 保存文章
     * @param article
     * @return
     */
    public int save(Article article);

    /**
     * 分页查询
     * @param page 页码（第几页）
     * @param pageSize 每页显示的笔数
     * @return
     */
    public PageInfo<Article> page(int page, int pageSize);
}
