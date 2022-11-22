package com.home.nanda.board.model.mapper;

import com.home.nanda.board.model.dto.Community;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {
    List<Community> searchAllArticles();
}
