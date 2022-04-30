package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.Favourite;
import com.musicBackend.musicBackend.models.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    @Query("Select f FROM Favourite f WHERE f.userId = ?1")
    Optional<List<Favourite>> findByUserId(Long userId);

    @Query("Select f FROM Favourite f WHERE f.id = ?1 AND f.userId = ?1")
    Optional<Favourite> findByDataIdAndUserId(Long id,Long userId);
}
