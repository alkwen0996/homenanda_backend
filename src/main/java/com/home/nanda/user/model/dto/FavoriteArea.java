package com.home.nanda.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FavoriteArea {
    private String userId;
    private String favoriteAreaCode;
    private String areaCode;
}
