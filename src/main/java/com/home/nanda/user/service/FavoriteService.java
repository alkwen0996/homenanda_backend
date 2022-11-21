package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.FavoriteArea;
import java.util.List;

public interface FavoriteService {

    List<FavoriteArea> findFavoriteAreas(String userId);

    void registerFavoriteArea(FavoriteArea favoriteArea);

}
