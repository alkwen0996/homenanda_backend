package com.home.nanda.board.model.mapper;

import com.home.nanda.board.model.dto.QnA;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnAMapper {
    List<QnA> searchAllQnA();

    QnA searchQnAById(String qnaId);
}
