package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.Article;
import com.home.nanda.board.model.dto.QnA;
import java.util.List;

public interface CommunityService {
    List<Article> searchAllArticles();
    Article searchArticleById(String articleId);
    void registerArticle(Article community);
    void updateHit(String articleId);
    void updateArticle(Article article);
    void deleteArticle(String articleId);
}
