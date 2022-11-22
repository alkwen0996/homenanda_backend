package com.home.nanda.board.model.mapper;

import com.home.nanda.board.model.dto.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {
    List<Article> searchAllArticles();
    Article searchArticleById(String articleId);
    void registerArticle(Article community);
    void updateHit(String articleId);
    void updateArticle(Article article);
    void deleteArticle(String articleId);
}
