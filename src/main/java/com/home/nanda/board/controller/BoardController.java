package com.home.nanda.board.controller;

import com.home.nanda.board.model.dto.Article;
import com.home.nanda.board.service.BoardService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class BoardController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private BoardService boardService;

    @Autowired
    public BoardController(final BoardService communityService) {
        this.boardService = communityService;
    }

    @GetMapping("/board/community")
    private ResponseEntity<List<Article>> searchAllArticles() {
        final List<Article> articles = boardService.searchAllArticles();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    } // 게시판 전체 글 목록 보기

    @GetMapping("/board/community/{articleId}")
    private ResponseEntity<Article> searchArticlesById(@PathVariable String articleId) {
        System.out.println("articleId: "+articleId);
        final Article article = boardService.searchArticleById(articleId);

        return new ResponseEntity<>(article, HttpStatus.OK);
    } // 게시판 글 상세 보기

    @PostMapping("/board/community")
    private ResponseEntity<?> registerArticle(@RequestBody Article article) {
        System.out.println("community in");
        System.out.println(article.toString());

        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try{
            boardService.registerArticle(article);
            status = HttpStatus.ACCEPTED;
            resultMap.put("message", SUCCESS);
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());
            resultMap.put("message", FAIL);
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(resultMap, status);
    } // 게시판 글 등록

    @PutMapping("/board/community/{articleId}")
    private ResponseEntity<Void> updateArticleHit(@PathVariable String articleId) {
        boardService.updateArticleHit(articleId);

        return new ResponseEntity<>(HttpStatus.OK);
    } // 게시판 글 조회수 업데이트

    @PutMapping("/board/community")
    private ResponseEntity<?> updateArticle(@RequestBody Article article) {
        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try{
            boardService.updateArticle(article);
            status = HttpStatus.ACCEPTED;
            resultMap.put("message", SUCCESS);
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());
            resultMap.put("message", FAIL);
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(resultMap, status);
    } // 게시판 글 제목 및 내용 수정

    @DeleteMapping("/board/community/{articleId}")
    private ResponseEntity<?> deleteArticle(@PathVariable String articleId) {
        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try{
            boardService.deleteArticle(articleId);
            status = HttpStatus.ACCEPTED;
            resultMap.put("message", SUCCESS);
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());
            resultMap.put("message", FAIL);
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(resultMap, status);
    } // 게시판 글 삭제


    @GetMapping("/board/qna")
    private ResponseEntity<List<Article>> searchAllQnA() {
        List<Article> qnaList = boardService.searchAllQnA();

        return new ResponseEntity<>(qnaList, HttpStatus.OK);
    } // qna 리스트보기

    @GetMapping("/board/qna/{articleId}")
    private ResponseEntity<Article> searchQnAById(@PathVariable String articleId) {
        final Article qnA = boardService.searchQnAById(articleId);

        return new ResponseEntity<>(qnA, HttpStatus.OK);
    } // qna 상세보기

    @PostMapping("/board/qna")
    private ResponseEntity<?> registerQnA(@RequestBody Article article) {
        System.out.println("qna in");
        System.out.println(article.toString());

        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try{
            boardService.registerQnA(article);
            status = HttpStatus.ACCEPTED;
            resultMap.put("message", SUCCESS);
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());
            resultMap.put("message", FAIL);
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(resultMap, status);
    } // qna 등록

    @PutMapping("/board/qna")
    private ResponseEntity<?> updateQnA(@RequestBody Article article) {
        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try{
            boardService.updateQnA(article);
            status = HttpStatus.ACCEPTED;
            resultMap.put("message", SUCCESS);
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());
            resultMap.put("message", FAIL);
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(resultMap, status);
    } // qna 제목 및 내용 수정

    @PutMapping("/board/qna/{article}")
    private ResponseEntity<Void> updateQnAHit(@PathVariable String article) {
        boardService.updateQnAHit(article);

        return new ResponseEntity<>(HttpStatus.OK);
    } // qna 조회수 업데이트

    @DeleteMapping("/board/qna/{article}")
    private ResponseEntity<?> deleteQnA(@PathVariable String article) {

        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try {
            boardService.deleteQnA(article);
            status = HttpStatus.ACCEPTED;
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
            resultMap.put("message", FAIL);
            status = HttpStatus.NO_CONTENT;
        } // qna 삭제

        return new ResponseEntity<>(resultMap, status);
    }

}
