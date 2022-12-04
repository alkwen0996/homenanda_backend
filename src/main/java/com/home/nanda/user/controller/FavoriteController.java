package com.home.nanda.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.nanda.house.model.dto.Area;
import com.home.nanda.house.model.dto.House;
import com.home.nanda.user.model.dto.UserArea;
import com.home.nanda.user.model.dto.UserHouse;
import com.home.nanda.user.service.FavoriteService;

@CrossOrigin("*")
@RestController
public class FavoriteController {

	private FavoriteService favoriteService;

	@Autowired
	public FavoriteController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}

	@GetMapping("/users/area/{userId}")
	private ResponseEntity<List<Area>> findFavoriteAreas(@PathVariable String userId) {
		final List<Area> favoriteAreas = favoriteService.findFavoriteAreas(userId);

		return new ResponseEntity<>(favoriteAreas, HttpStatus.OK);
	}

	@PostMapping("/users/area")
	private ResponseEntity<List<UserArea>> registerFavoriteAreas(@RequestBody UserArea userArea) {
		favoriteService.registerFavoriteArea(userArea);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/users/area/{areaCode}")
	private ResponseEntity<List<UserArea>> deleteFavoriteArea(@PathVariable String areaCode) {
		favoriteService.deleteFavoriteArea(areaCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/users/house/{userId}")
	private ResponseEntity<List<House>> findFavoriteHouses(@PathVariable String userId) {
		final List<House> favoriteAreas = favoriteService.findFavoriteHouses(userId);

		return new ResponseEntity<>(favoriteAreas, HttpStatus.OK);
	}

	@PostMapping("/users/house")
	private ResponseEntity<List<UserArea>> registerFavoriteHouses(@RequestBody UserHouse userHouse) {
		favoriteService.registerFavoriteHouses(userHouse);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/users/house/{houseCode}")
	private ResponseEntity<List<UserArea>> deleteFavoriteHouse(@PathVariable String houseCode) {
		favoriteService.deleteFavoriteHouse(houseCode);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
