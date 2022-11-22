package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.ArticleComment;
import java.util.List;

public interface CommentService {
    List<ArticleComment> searchCommentsByArticleId(String articleId);
}
