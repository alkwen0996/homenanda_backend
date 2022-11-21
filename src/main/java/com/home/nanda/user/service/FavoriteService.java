package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.FavoriteArea;
import com.home.nanda.user.model.dto.FavoriteHouse;
import java.util.List;

public interface FavoriteService {

    List<FavoriteArea> findFavoriteAreas(String userId);

    void registerFavoriteArea(FavoriteArea favoriteArea);

    void deleteFavoriteArea(String areaFavoriteCode);

    List<FavoriteHouse> findFavoriteHouses(String userId);
}
