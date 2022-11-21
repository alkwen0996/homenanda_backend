package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.QnA;
import java.util.List;

public interface QnAService {
    List<QnA> searchAllQnA();
    QnA searchQnAById(String qnaId);
    void registerQnA(QnA qnA);
    void deleteQnA(String qnaId);
    void updateQnA(QnA qnA);
}
