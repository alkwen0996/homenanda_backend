package com.home.nanda.house.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.nanda.house.model.dto.Deal;
import com.home.nanda.house.model.mapper.DealMapper;
@Service
public class DealServiceImpl implements DealService{

	private DealMapper dealMapper;
	
	@Autowired
	public DealServiceImpl(DealMapper dealMapper) {
		super();
		this.dealMapper = dealMapper;
	}
	
	@Override
	public List<Deal> getDealFromApart(int apartCode) throws SQLException {
		// TODO Auto-generated method stub
		return dealMapper.getDealFromApart(apartCode);
	}

	
}
