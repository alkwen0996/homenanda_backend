package com.home.nanda.board.service;


import com.home.nanda.board.model.dto.Article;
import com.home.nanda.board.model.mapper.CommunityMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {

    private CommunityMapper communityMapper;

    @Autowired
    public CommunityServiceImpl(final CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }

    @Override
    public List<Article> searchAllArticles() {
        return communityMapper.searchAllArticles();
    }

    @Override
    public Article searchArticleById(final String articleId) {
        return communityMapper.searchArticleById(articleId);
    }

    @Override
    public void registerArticle(final Article community) {
        communityMapper.registerArticle(community);
    }

    @Override
    public void updateHit(final String articleId) {
        communityMapper.updateHit(articleId);
    }

    @Override
    public void updateArticle(final Article article) {
        communityMapper.updateArticle(article);
    }

    @Override
    public void deleteArticle(final String articleId) {
        communityMapper.deleteArticle(articleId);
    }

}
