package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> searchCommentsByArticleId(String articleId);
    void registerArticleComment(Comment articleComment);

    void updateArticleComment(Comment articleComment);
    void deleteArticleComment(String commentId);
    List<Comment> searchQnAByQnAId(String qnaId);
}
