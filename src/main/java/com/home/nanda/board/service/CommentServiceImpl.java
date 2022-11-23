package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.Comment;
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
    public List<Comment> searchCommentsByArticleId(final String articleId) {
        return commentMapper.searchCommentsByArticleId(articleId);
    }

    @Override
    public void registerArticleComment(final Comment articleComment) {
        commentMapper.registerArticleComment(articleComment);
    }

    @Override
    public void updateArticleComment(final Comment articleComment) {
        commentMapper.updateArticleComment(articleComment);
    }

    @Override
    public void deleteArticleComment(final String commentId) {
        commentMapper.deleteArticleComment(commentId);
    }

    @Override
    public List<Comment> searchQnAByQnAId(final String qnaId) {
        return commentMapper.searchQnAByQnAId(qnaId);
    }

}
