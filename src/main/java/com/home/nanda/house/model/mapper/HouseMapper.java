package com.home.nanda.house.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;

@Mapper
public interface HouseMapper {
	List<House> getApartFromGugun(Area area) throws SQLException;
	List<House> getApartFromDong(Area area) throws SQLException;
	List<House> getApartFromCode(Area area) throws SQLException;
}
