package com.home.nanda.user.service;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
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
	public void registerFavoriteArea(FavoriteArea favoriteArea) {
		// TODO Auto-generated method stub
		favoriteMapper.registerFavoriteArea(favoriteArea);
	}

	@Override
	public void deleteFavoriteArea(String areaCode) {
		// TODO Auto-generated method stub
		favoriteMapper.deleteFavoriteArea(areaCode);
	}

	@Override
	public void registerFavoriteHouses(FavoriteHouse favoriteHouse) {
		// TODO Auto-generated method stub
		favoriteMapper.registerFavoriteHouses(favoriteHouse);
	}

	@Override
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
