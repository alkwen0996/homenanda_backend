package com.home.nanda.house.service;

import java.sql.SQLException;
import java.util.List;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;

public interface HouseService {
	List<House> getApartFromGugun(Area area)throws SQLException ;
	List<House> getApartFromDong(Area area)throws SQLException ;
	List<House> getApartFromCode(Area area)throws SQLException ;
}
