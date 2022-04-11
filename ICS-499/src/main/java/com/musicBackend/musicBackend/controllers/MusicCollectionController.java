package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.MusicCollection;
import com.musicBackend.musicBackend.models.PlayList;
import com.musicBackend.musicBackend.services.MusicCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/musicCollection")
public class MusicCollectionController {
    private final MusicCollectionService musicCollectionService;

    @Autowired
    public MusicCollectionController(MusicCollectionService musicCollectionService){
        this.musicCollectionService = musicCollectionService;
    }

    @PostMapping
    public void addMusicCollection(@RequestBody MusicCollection musicCollection) {
        musicCollectionService.addMusicCollection(musicCollection);
    }

    @DeleteMapping(path = "{musicCollectionId}")
    public void deletePermission(@PathVariable("musicCollectionId") Long musicCollectionId){
        musicCollectionService.deleteMusicCollection(musicCollectionId);
    }

    @GetMapping("/countOfPlaylistsInCollection")
    public Integer countOfPlaylistsInCollection(@RequestParam(name="musicCollectionId") long musicCollectionId) {
        return musicCollectionService.countOfPlaylistsInCollection(musicCollectionId);
    }

    @GetMapping("/getMusicCollection")
    public MusicCollection getMusicCollection(@RequestParam(name="musicCollectionId") long musicCollectionId) {
        return musicCollectionService.getMusicCollection(musicCollectionId);
    }
}
