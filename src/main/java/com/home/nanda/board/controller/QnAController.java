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
    }

    @GetMapping("/board/qna/{qnaId}")
    private ResponseEntity<QnA> searchQnAById(@PathVariable String qnaId) {
        final QnA qnA = qnAService.searchQnAById(qnaId);

        return new ResponseEntity<>(qnA, HttpStatus.OK);
    }

    @PostMapping("/board/qna")
    private ResponseEntity<Void> registerQnA(@RequestBody QnA qna) {
        qnAService.registerQnA(qna);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/board/qna/{qnaId}")
    private ResponseEntity<Void> deleteQnA(@PathVariable String qnaId) {
        qnAService.deleteQnA(qnaId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
