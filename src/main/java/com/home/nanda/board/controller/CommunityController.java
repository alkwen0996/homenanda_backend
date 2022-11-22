package com.home.nanda.board.controller;

import com.home.nanda.board.model.dto.Community;
import com.home.nanda.board.service.CommunityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {

    private CommunityService communityService;

    @Autowired
    public CommunityController(final CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/board/community")
    private ResponseEntity<List<Community>> searchAllQnA() {
        List<Community> articles = communityService.searchAllArticles();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    } // community 리스트 보기

}
