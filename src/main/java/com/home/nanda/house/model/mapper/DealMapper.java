package com.home.nanda.house.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.home.nanda.house.model.dto.Deal;

@Mapper
public interface DealMapper {
	List<Deal> getDealFromApart(int apartCode) throws SQLException;
}
