package com.home.nanda.user.controller;

import com.home.nanda.user.model.dto.FavoriteArea;
import com.home.nanda.user.service.FavoriteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoriteController {

    private FavoriteService favoriteService;

    @Autowired
    public FavoriteController(final FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/users/area/{userId}")
    private ResponseEntity<List<FavoriteArea>> findFavoriteAreas(@PathVariable String userId){
        final List<FavoriteArea> favoriteAreas = favoriteService.findFavoriteAreas(userId);

        return new ResponseEntity<>(favoriteAreas, HttpStatus.OK);
    }

}
