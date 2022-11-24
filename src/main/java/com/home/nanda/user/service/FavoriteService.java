package com.home.nanda.user.service;

import java.util.List;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.user.model.dto.FavoriteArea;
import com.home.nanda.user.model.dto.FavoriteHouse;

public interface FavoriteService {

	List<Area> findFavoriteAreas(String userId);

	void registerFavoriteArea(FavoriteArea favoriteArea);

	void deleteFavoriteArea(String areaCode);

	List<House> findFavoriteHouses(String userId);

	void registerFavoriteHouses(FavoriteHouse favoriteHouse);

	void deleteFavoriteHouse(String houseCode);

}
