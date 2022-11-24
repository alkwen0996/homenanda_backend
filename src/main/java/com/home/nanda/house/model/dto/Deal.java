package com.home.nanda.house.model.dto;

import lombok.Data;

@Data
public class Deal {
	Long dealCode;
	String dealPrice;
	Long dealYear;
	Long dealMonth;
	Long dealDay;
	String area;
	String floor;
	Long houseCode;
	String type;
	String rentMoney;
}
