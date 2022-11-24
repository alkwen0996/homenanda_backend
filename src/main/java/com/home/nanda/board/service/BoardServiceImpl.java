package com.home.nanda.board.service;


import com.home.nanda.board.model.dto.Article;
import com.home.nanda.board.model.mapper.BoardMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardMapper boardMapper;


    @Autowired
    public BoardServiceImpl(final BoardMapper communityMapper) {
        this.boardMapper = communityMapper;
    }

    @Override
    public List<Article> searchAllArticles() {
        return boardMapper.searchAllArticles();
    }

    @Override
    public Article searchArticleById(final String articleId) {
        return boardMapper.searchArticleById(articleId);
    }

    @Override
    @Transactional
    public void registerArticle(final Article community) {
        System.out.println("in serviceImpl");
        boardMapper.registerArticle(community);
    }

    @Override
    public void updateArticleHit(final String articleId) {
        boardMapper.updateArticleHit(articleId);
    }

    @Override
    public void updateArticle(final Article article) {
        boardMapper.updateArticle(article);
    }

    @Override
    @Transactional
    public void deleteArticle(final String articleId) {
        boardMapper.deleteArticle(articleId);
    }

    @Override
    public List<Article> searchAllQnA() {
        return boardMapper.searchAllQnA();
    }

    @Override
    public Article searchQnAById(final String qnaId) {
        return boardMapper.searchQnAById(qnaId);
    }

    @Override
    @Transactional
    public void registerQnA(final Article qnA) {
        boardMapper.registerQnA(qnA);
    }

    @Override
    @Transactional
    public void deleteQnA(final String qnaId) {
        boardMapper.deleteQnA(qnaId);
    }

    @Override
    public void updateQnA(final Article qnA) {
        boardMapper.updateQnA(qnA);
    }

    @Override
    public void updateQnAHit(final String qnaId) {
        boardMapper.updateQnAHit(qnaId);
    }

}
