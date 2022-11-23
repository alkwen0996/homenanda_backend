package com.home.nanda.house.service;

import java.sql.SQLException;
import java.util.List;

import com.home.nanda.house.model.dto.Deal;

public interface DealService {
	List<Deal> getDealFromApart(int apartCode)throws SQLException ;
}
