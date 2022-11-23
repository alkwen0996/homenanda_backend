package com.home.nanda.board.model.mapper;

import com.home.nanda.board.model.dto.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    List<Comment> searchCommentsByArticleId(String articleId);
    void registerArticleComment(Comment articleComment);
    void updateArticleComment(Comment articleComment);
    void deleteArticleComment(String commentId);
    List<Comment> searchQnAByQnAId(String qnaId);
}
