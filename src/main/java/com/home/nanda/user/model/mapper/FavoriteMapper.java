package com.home.nanda.user.model.mapper;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.user.model.dto.UserArea;
import com.home.nanda.user.model.dto.UserHouse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoriteMapper {
	List<Area> findFavoriteAreas(String userId);

	void registerFavoriteArea(UserArea userArea);

	void deleteFavoriteArea(String areaCode);

	List<House> findFavoriteHouses(String userId);

	void registerFavoriteHouses(UserHouse userHouse);

	void deleteFavoriteHouse(String houseCode);

}
