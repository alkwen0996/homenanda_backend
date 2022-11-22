package com.home.nanda.board.controller;

import com.home.nanda.board.model.dto.Article;
import com.home.nanda.board.service.CommunityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {

    private CommunityService communityService;

    @Autowired
    public CommunityController(final CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/board/community")
    private ResponseEntity<List<Article>> searchAllArticles() {
        final List<Article> articles = communityService.searchAllArticles();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    } // 게시판 전체 글 목록 보기

    @GetMapping("/board/community/{articleId}")
    private ResponseEntity<Article> searchArticlesById(@PathVariable String articleId) {
        final Article article = communityService.searchArticleById(articleId);

        return new ResponseEntity<>(article, HttpStatus.OK);
    } // 게시판 글 상세 보기

    @PostMapping("/board/community")
    private ResponseEntity<Void> registerArticle(@RequestBody Article article) {
        communityService.registerArticle(article);

        return new ResponseEntity<>(HttpStatus.OK);
    } // 게시판 글 등록

    @PutMapping("/board/community/{articleId}")
    private ResponseEntity<Void> updateHit(@PathVariable String articleId) {
        communityService.updateHit(articleId);

        return new ResponseEntity<>(HttpStatus.OK);
    } // qna 조회수 업데이트

}
