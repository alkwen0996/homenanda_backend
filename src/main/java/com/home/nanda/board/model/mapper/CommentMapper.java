package com.home.nanda.board.model.mapper;

import com.home.nanda.board.model.dto.ArticleComment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    List<ArticleComment> searchCommentsByArticleId(String articleId);
    void registerArticleComment(ArticleComment articleComment);
    void updateArticleComment(ArticleComment articleComment);
    void deleteArticleComment(String commentId);
}
