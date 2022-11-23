package com.home.nanda.house.model.dto;

import lombok.Data;

@Data
public class Deal {
	int dealCode;
	String dealPrice;
	int dealYear;
	int dealMonth;
	int dealDay;
	String area;
	String floor;
	int houseCode;
	String type;
	String rentMoney;
}
