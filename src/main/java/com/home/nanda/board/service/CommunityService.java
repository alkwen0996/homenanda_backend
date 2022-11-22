package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.Article;
import java.util.List;

public interface CommunityService {
    List<Article> searchAllArticles();
    Article searchArticleById(String articleId);
    void registerArticle(Article community);
    void updateHit(String articleId);
}
