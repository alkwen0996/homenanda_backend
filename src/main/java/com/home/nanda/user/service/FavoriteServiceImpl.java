package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.FavoriteArea;
import com.home.nanda.user.model.dto.FavoriteHouse;
import com.home.nanda.user.model.mapper.FavoriteMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    private FavoriteMapper favoriteMapper;

    @Autowired
    public FavoriteServiceImpl(final FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }

    @Override
    public List<FavoriteArea> findFavoriteAreas(final String userId) {
        return favoriteMapper.findFavoriteAreas(userId);
    }

    @Override
    public void registerFavoriteArea(final FavoriteArea favoriteArea) {
        favoriteMapper.registerFavoriteArea(favoriteArea);
    }

    @Override
    public void deleteFavoriteArea(final String areaFavoriteCode) {
        favoriteMapper.deleteFavoriteArea(areaFavoriteCode);
    }

    @Override
    public List<FavoriteHouse> findFavoriteHouses(final String userId) {
        return favoriteMapper.findFavoriteHouses(userId);
    }

    @Override
    public void registerFavoriteHouses(final FavoriteHouse favoriteHouse) {
        favoriteMapper.registerFavoriteHouses(favoriteHouse);
    }

}
