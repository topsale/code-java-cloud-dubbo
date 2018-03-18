package com.ooqiu.gaming.service.search.test;

import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.service.search.mapper.ArticleMapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SolrTest {
    private static final String SOLR_COLLECTION = "ik_core";

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 新增
     */
    @Test
    public void addDocument() throws IOException, SolrServerException {
        // 准备数据
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", 152034938305036L);
        document.addField("article_title", "新演示 胖怪物、巨型蜘蛛压迫感十足");
        document.addField("article_source", "我的头条");

        // 添加数据到 Solr
        solrClient.add(SOLR_COLLECTION, document);
        solrClient.commit(SOLR_COLLECTION);
    }

    /**
     * 删除
     */
    @Test
    public void delDocument() throws IOException, SolrServerException {
        solrClient.deleteByQuery(SOLR_COLLECTION, "*:*");
        solrClient.commit(SOLR_COLLECTION);
    }

    /**
     * 初始化索引库
     */
    @Test
    public void initDocument() throws IOException, SolrServerException {
        List<Article> articles = articleMapper.selectAll();

        for (Article article : articles) {
            SolrInputDocument document = new SolrInputDocument();

            document.addField("id", article.getId());
            document.addField("article_title", article.getTitle());
            document.addField("article_source", article.getSource());
            document.addField("article_url", article.getUrl());
            document.addField("article_introduction", article.getIntroduction());
            document.addField("article_cover", article.getCover());

            solrClient.add(SOLR_COLLECTION, document);
            solrClient.commit(SOLR_COLLECTION);
        }
    }

    /**
     * 查询
     */
    @Test
    public void queryDocument() throws IOException, SolrServerException {
        // 创建查询对象
        SolrQuery query = new SolrQuery();

        // 设置查询条件
        query.setQuery("游戏");

        // 设置分页
        query.setStart(0);
        query.setRows(10);

        // 设置默认域
        query.set("df", "article_keywords");

        // 设置高亮
        query.setHighlight(true);
        query.addHighlightField("article_title");
        query.setHighlightSimplePre("<span style='color:red;'>");
        query.setHighlightSimplePost("</span>");

        // 获取查询结果
        QueryResponse queryResponse = solrClient.query(SOLR_COLLECTION, query);
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        for (SolrDocument document : solrDocumentList) {
            String articleTitle = "";

            List<String> highList = highlighting.get(document.get("id")).get("article_title");
            if (highList != null && highList.size() > 0) {
                articleTitle = highList.get(0);
            }

            else {
                articleTitle = (String) document.get("article_title");
            }

            System.out.println(articleTitle);
        }
    }
}
