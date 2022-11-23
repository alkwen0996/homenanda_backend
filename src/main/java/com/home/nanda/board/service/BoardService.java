package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.Article;
import java.util.List;

public interface BoardService {
    List<Article> searchAllArticles();
    Article searchArticleById(String articleId);
    void registerArticle(Article community);
    void updateArticleHit(String articleId);
    void updateArticle(Article article);
    void deleteArticle(String articleId);

    List<Article> searchAllQnA();
    Article searchQnAById(String qnaId);
    void registerQnA(Article qnA);
    void deleteQnA(String qnaId);
    void updateQnA(Article qnA);
    void updateQnAHit(String qnaId);
}
