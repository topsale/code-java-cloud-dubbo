package com.ooqiu.gaming.service.search.domain;

import java.io.Serializable;

/**
 * 自定义搜索结果集
 * <p>Title: SearchResult</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/13 10:46
 */
public class SearchResult implements Serializable {
    private String id;
    private String article_title;
    private String article_url;
    private String article_source;
    private String article_introduction;
    private String article_cover;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getArticle_source() {
        return article_source;
    }

    public void setArticle_source(String article_source) {
        this.article_source = article_source;
    }

    public String getArticle_introduction() {
        return article_introduction;
    }

    public void setArticle_introduction(String article_introduction) {
        this.article_introduction = article_introduction;
    }

    public String getArticle_cover() {
        return article_cover;
    }

    public void setArticle_cover(String article_cover) {
        this.article_cover = article_cover;
    }
}
