package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.Favourite;
import com.musicBackend.musicBackend.models.PlayList;
import com.musicBackend.musicBackend.models.Track;
import com.musicBackend.musicBackend.repositories.FavouriteRepository;
import com.musicBackend.musicBackend.repositories.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FavouriteService {

    private final FavouriteRepository favouriteRepository;
    private final TrackService trackService;
    @Autowired
    public FavouriteService(FavouriteRepository favouriteRepository, TrackService trackService) {
        this.favouriteRepository = favouriteRepository;
        this.trackService = trackService;
    }

    public List<Favourite> findByUserId(Long userId){
        Optional<List<Favourite>> favouriteOptional = favouriteRepository.findByUserId(userId);
        return favouriteOptional.get();
    }

    public void addTrackToFavourite (Long id, Long userId, Long trackId){
        Favourite favourite = favouriteRepository.findByDataIdAndUserId(id, userId).get();
        favourite.getTracks().add(trackService.getTrackById(trackId));
        favouriteRepository.save(favourite);
    }

    public void deleteTrackFromFavourite (Long id, Long userId, Long trackId){
        Favourite favourite = favouriteRepository.findByDataIdAndUserId(id, userId).get();
        favourite.getTracks().remove(trackService.getTrackById(trackId));
        favouriteRepository.save(favourite);
    }

    public Favourite findById (Long id, Long userId){
        Optional<Favourite> favourite = favouriteRepository.findByDataIdAndUserId(id, userId);
        return favourite.get();
    }

    public void deleteFavourite (Long id){
        boolean exists = favouriteRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Favourite with id " + id + " does not exists.");
        }
        favouriteRepository.deleteById(id);
    }

    public void addFavourite (Favourite favourite){
        favouriteRepository.save(favourite);
    }
}
