package com.home.nanda.board.controller;

import com.home.nanda.board.model.dto.Comment;
import com.home.nanda.board.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(final CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/board/comment/article/{articleId}")
    private ResponseEntity<List<Comment>> searchCommentsByArticleId(@PathVariable String articleId){
        final List<Comment> articleComments = commentService.searchCommentsByArticleId(articleId);

        return new ResponseEntity<>(articleComments, HttpStatus.OK);
    }

    @PostMapping("/board/comment/article")
    private ResponseEntity<Void> registerArticleComment(@RequestBody Comment articleComment){
        commentService.registerArticleComment(articleComment);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/board/comment/article")
    private ResponseEntity<Void> updateArticleComment(@RequestBody Comment articleComment){
        commentService.updateArticleComment(articleComment);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/board/comment/article/{articleId}")
    private ResponseEntity<Void> deleteArticleComment(@PathVariable String articleId){
        commentService.deleteArticleComment(articleId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/board/comment/qna/{articleId}")
    private ResponseEntity<List<Comment>> searchCommentsByQnAId(@PathVariable String articleId){
        final List<Comment> qnaComments = commentService.searchQnAByQnAId(articleId);

        return new ResponseEntity<>(qnaComments, HttpStatus.OK);
    }

}
