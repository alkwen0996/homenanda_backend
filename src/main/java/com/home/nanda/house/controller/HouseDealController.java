package com.home.nanda.house.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.Deal;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.house.service.DealServiceImpl;
import com.home.nanda.house.service.HouseServiceImpl;

@CrossOrigin("*")
@RestController
public class HouseDealController {
	private DealServiceImpl dealServiceImpl;
	private HouseServiceImpl houseServiceImpl;

	@Autowired
	public HouseDealController(DealServiceImpl dealServiceImpl, HouseServiceImpl houseServiceImpl) {
		super();
		this.dealServiceImpl = dealServiceImpl;
		this.houseServiceImpl = houseServiceImpl;
	}

	@GetMapping("/aparts")
	private ResponseEntity<?> getDealFromApart(int apartCode) {
		try {
			List<Deal> deals = dealServiceImpl.getDealFromApart(apartCode);
			return new ResponseEntity<List<Deal>>(deals,HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/aparts/dong")
	private ResponseEntity<?> getApartFromDong(@RequestBody Area area) {
		try {
			List<House> houses = houseServiceImpl.getApartFromDong(area);
			return new ResponseEntity<List<House>>(houses,HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/aparts/gu")
	private ResponseEntity<?> getApartFromGugun(@RequestBody Area area) {
		try {
			List<House> houses = houseServiceImpl.getApartFromGugun(area);
			return new ResponseEntity<List<House>>(houses,HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/aparts/code")
	private ResponseEntity<?> getApartFromCode(@RequestBody Area area) {
//		System.out.println(area);
		try {
			List<House> houses = houseServiceImpl.getApartFromCode(area);
//			if(!houses.isEmpty() )
//				System.out.println(houses.get(0));
			return new ResponseEntity<List<House>>(houses,HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
