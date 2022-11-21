package com.home.nanda.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FavoriteBuilding {
    private String userId;
    private String buildingCode;
    private String myBuildingCode;
}
