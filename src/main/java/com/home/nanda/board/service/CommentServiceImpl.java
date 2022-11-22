package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.ArticleComment;
import com.home.nanda.board.model.mapper.CommentMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(final CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<ArticleComment> searchCommentsByArticleId(final String articleId) {
        return commentMapper.searchCommentsByArticleId(articleId);
    }

}
