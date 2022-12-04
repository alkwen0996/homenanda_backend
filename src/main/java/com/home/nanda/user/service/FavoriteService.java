package com.home.nanda.user.service;

import java.util.List;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.user.model.dto.UserArea;
import com.home.nanda.user.model.dto.UserHouse;

public interface FavoriteService {

	List<Area> findFavoriteAreas(String userId);

	void registerFavoriteArea(UserArea userArea);

	void deleteFavoriteArea(String areaCode);

	List<House> findFavoriteHouses(String userId);

	void registerFavoriteHouses(UserHouse userHouse);

	void deleteFavoriteHouse(String houseCode);

}
