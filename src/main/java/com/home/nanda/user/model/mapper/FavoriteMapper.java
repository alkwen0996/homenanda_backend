package com.home.nanda.user.model.mapper;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.user.model.dto.FavoriteArea;
import com.home.nanda.user.model.dto.FavoriteHouse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoriteMapper {
	List<Area> findFavoriteAreas(String userId);

	void registerFavoriteArea(FavoriteArea favoriteArea);

	void deleteFavoriteArea(String areaCode);

	List<House> findFavoriteHouses(String userId);

	void registerFavoriteHouses(FavoriteHouse favoriteHouse);

	void deleteFavoriteHouse(String houseCode);

}
