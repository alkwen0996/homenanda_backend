package com.home.nanda.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.user.model.dto.UserArea;
import com.home.nanda.user.model.dto.UserHouse;
import com.home.nanda.user.model.mapper.FavoriteMapper;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    private FavoriteMapper favoriteMapper;

    @Autowired
    public FavoriteServiceImpl(final FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }

	@Override
	@Transactional
	public void registerFavoriteArea(UserArea userArea) {
		// TODO Auto-generated method stub
		favoriteMapper.registerFavoriteArea(userArea);
	}

	@Override
	@Transactional
	public void deleteFavoriteArea(String areaCode) {
		// TODO Auto-generated method stub
		favoriteMapper.deleteFavoriteArea(areaCode);
	}

	@Override
	@Transactional
	public void registerFavoriteHouses(UserHouse userHouse) {
		// TODO Auto-generated method stub
		favoriteMapper.registerFavoriteHouses(userHouse);
	}

	@Override
	@Transactional
	public void deleteFavoriteHouse(String houseCode) {
		// TODO Auto-generated method stub
		favoriteMapper.deleteFavoriteHouse(houseCode);
	}

	@Override
	public List<Area> findFavoriteAreas(String userId) {
		// TODO Auto-generated method stub
		return favoriteMapper.findFavoriteAreas(userId);
	}

	@Override
	public List<House> findFavoriteHouses(String userId) {
		// TODO Auto-generated method stub
		return favoriteMapper.findFavoriteHouses(userId);
	}


    
}
