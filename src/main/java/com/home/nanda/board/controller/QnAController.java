package com.home.nanda.board.controller;

import com.home.nanda.board.model.dto.QnA;
import com.home.nanda.board.service.QnAService;
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
public class QnAController {

    private QnAService qnAService;

    @Autowired
    public QnAController(final QnAService qnAService) {
        this.qnAService = qnAService;
    }

    @GetMapping("/board/qna")
    private ResponseEntity<List<QnA>> searchAllQnA() {
        List<QnA> qnaList = qnAService.searchAllQnA();

        return new ResponseEntity<>(qnaList, HttpStatus.OK);
    } // qna 리스트보기

    @GetMapping("/board/qna/{qnaId}")
    private ResponseEntity<QnA> searchQnAById(@PathVariable String qnaId) {
        final QnA qnA = qnAService.searchQnAById(qnaId);

        return new ResponseEntity<>(qnA, HttpStatus.OK);
    } // qna 상세보기

    @PostMapping("/board/qna")
    private ResponseEntity<Void> registerQnA(@RequestBody QnA qna) {
        qnAService.registerQnA(qna);

        return new ResponseEntity<>(HttpStatus.OK);
    } // qna 등록

    @PutMapping("/board/qna")
    private ResponseEntity<Void> updateQnA(@RequestBody QnA qna) {
        qnAService.updateQnA(qna);

        return new ResponseEntity<>(HttpStatus.OK);
    } // qna 제목 및 내용 수정

    @PutMapping("/board/qna/{qnaId}")
    private ResponseEntity<Void> updateHit(@PathVariable String qnaId) {
        qnAService.updateHit(qnaId);

        return new ResponseEntity<>(HttpStatus.OK);
    } // qna 조회수 업데이트

    @DeleteMapping("/board/qna/{qnaId}")
    private ResponseEntity<Void> deleteQnA(@PathVariable String qnaId) {
        qnAService.deleteQnA(qnaId);

        return new ResponseEntity<>(HttpStatus.OK);
    } // qna 삭제

}
