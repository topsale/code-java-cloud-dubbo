package com.ooqiu.gaming.service.search.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.ooqiu.gaming.service.search.api.SearchService;
import com.ooqiu.gaming.service.search.domain.SearchResult;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_SEARCH)
public class SearchServiceImpl implements SearchService {
    private static final String SOLR_COLLECTION = "ik_core";

    @Autowired
    private SolrClient solrClient;

    @Override
    public List<SearchResult> search(String query, int page, int row) {
        List<SearchResult> results = Lists.newArrayList();

        // 新建查询对象
        SolrQuery solrQuery = new SolrQuery();

        // 设置查询条件
        solrQuery.setQuery(query);

        // 设置分页
        solrQuery.setStart((page - 1) * row);
        solrQuery.setRows(row);

        // 设置查询域
        solrQuery.set("df", "article_keywords");

        // 设置高亮显示
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("article_title");
        solrQuery.setHighlightSimplePre("<span style='color:red'>");
        solrQuery.setHighlightSimplePost("</span>");

        try {
            QueryResponse queryResponse = solrClient.query(SOLR_COLLECTION, solrQuery);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();

            for (SolrDocument document : solrDocumentList) {
                SearchResult searchResult = new SearchResult();

                searchResult.setId((String) document.get("id"));
                searchResult.setArticle_url((String) document.get("article_url"));
                searchResult.setArticle_source((String) document.get("article_source"));
                searchResult.setArticle_introduction((String) document.get("article_introduction"));
                searchResult.setArticle_cover((String) document.get("article_cover"));

                String articleTitle = "";
                List<String> highList = highlighting.get(document.get("id")).get("article_title");
                if (highList != null && highList.size() > 0) {
                    articleTitle = highList.get(0);
                } else {
                    articleTitle = (String) document.get("article_title");
                }
                searchResult.setArticle_title(articleTitle);

                results.add(searchResult);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}
