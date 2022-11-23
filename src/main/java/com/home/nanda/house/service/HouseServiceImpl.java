package com.home.nanda.house.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.house.model.mapper.HouseMapper;
@Service
public class HouseServiceImpl implements HouseService{

	private HouseMapper houseMapper;
	
	@Autowired
	public HouseServiceImpl(HouseMapper houseMapper) {
		super();
		this.houseMapper = houseMapper;
	}

	@Override
	public List<House> getApartFromGugun(Area area) throws SQLException {
		// TODO Auto-generated method stub
		return  houseMapper.getApartFromGugun(area);
	}

	@Override
	public List<House> getApartFromDong(Area area)throws SQLException  {
		// TODO Auto-generated method stub
		return houseMapper.getApartFromDong(area);
	}

	@Override
	public List<House> getApartFromCode(Area area) throws SQLException {
		// TODO Auto-generated method stub
		String code = area.getAreaCode();
		code = code.substring(0, 5)+"_____";
		area.setAreaCode(code);
//		System.out.println("code : "+code);
		return houseMapper.getApartFromCode(area);
	}
}
