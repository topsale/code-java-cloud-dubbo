package com.ooqiu.gaming.service.search.api;

import com.ooqiu.gaming.service.search.domain.SearchResult;

import java.util.List;

public interface SearchService {
    public List<SearchResult> search(String query, int page, int row);
}
