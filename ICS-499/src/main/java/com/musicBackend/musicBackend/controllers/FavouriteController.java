package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Favourite;
import com.musicBackend.musicBackend.models.PlayList;
import com.musicBackend.musicBackend.services.FavouriteService;
import com.musicBackend.musicBackend.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/favourite")
public class FavouriteController {
    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService){
        this.favouriteService = favouriteService;
    }

    @PostMapping
    public void addFavourite(@RequestBody Favourite favourite) {
        favouriteService.addFavourite(favourite);
    }

    @DeleteMapping
    public void deleteFavourite(@RequestParam("favouriteId") Long favouriteId){
        favouriteService.deleteFavourite(favouriteId);
    }

    @GetMapping("/findByUserId")
    public List<Favourite> findByUserId(@RequestParam(name="userId") long userId) {
        return favouriteService.findByUserId(userId);
    }

    @GetMapping("/addTrackToFavourite")
    public void addTrackToFavourite(@RequestParam(name="favouriteId") long favouriteId, @RequestParam(name="userId") long userId, @RequestParam(name="trackId") long trackId) {
        favouriteService.addTrackToFavourite(favouriteId, userId, trackId);
    }

    @GetMapping("/deleteTrackFromFavourite")
    public void deleteTrackFromFavourite(@RequestParam(name="favouriteId") long favouriteId, @RequestParam(name="userId") long userId, @RequestParam(name="trackId") long trackId) {
        favouriteService.deleteTrackFromFavourite(favouriteId, userId, trackId);
    }

    @GetMapping("/findById")
    public Favourite findById(@RequestParam(name="playListId") long playListId, @RequestParam(name="trackId") long trackId) {
        return favouriteService.findById(playListId, trackId);
    }
}
