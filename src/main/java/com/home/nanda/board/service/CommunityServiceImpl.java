package com.home.nanda.board.service;


import com.home.nanda.board.model.dto.Community;
import com.home.nanda.board.model.mapper.CommunityMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {

    private CommunityMapper communityMapper;

    @Autowired
    public CommunityServiceImpl(final CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }

    @Override
    public List<Community> searchAllArticles() {
        return communityMapper.searchAllArticles();
    }

}
