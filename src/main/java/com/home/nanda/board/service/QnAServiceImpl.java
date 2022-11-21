package com.home.nanda.board.service;

import com.home.nanda.board.model.dto.QnA;
import com.home.nanda.board.model.mapper.QnAMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnAServiceImpl implements QnAService {

    private QnAMapper qnAMapper;

    @Autowired
    public QnAServiceImpl(final QnAMapper qnAMapper) {
        this.qnAMapper = qnAMapper;
    }

    @Override
    public List<QnA> searchAllQnA() {
        return qnAMapper.searchAllQnA();
    }

    @Override
    public QnA searchQnAById(final String qnaId) {
        return qnAMapper.searchQnAById(qnaId);
    }

}
