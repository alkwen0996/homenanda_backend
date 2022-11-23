package com.home.nanda.board.model.mapper;

import com.home.nanda.board.model.dto.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    // 자유 게시판 기능
    List<Article> searchAllArticles();
    Article searchArticleById(String articleId);
    void registerArticle(Article community);
    void updateArticleHit(String articleId);
    void updateArticle(Article article);
    void deleteArticle(String articleId);

    // qna 게시판 기능
    List<Article> searchAllQnA();
    Article searchQnAById(String articleId);
    void registerQnA(Article article);
    void deleteQnA(String articleId);
    void updateQnA(Article article);
    void updateQnAHit(String articleId);
}
