package com.home.nanda.user.model.mapper;

import com.home.nanda.user.model.dto.FavoriteArea;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoriteMapper {
    List<FavoriteArea> findFavoriteAreas(String userId);

    void registerFavoriteArea(FavoriteArea favoriteArea);

}
