package com.musicBackend.musicBackend.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Favourite {
    @Id
    @SequenceGenerator(
            name = "favourite_sequence",
            sequenceName = "favourite_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "favourite_sequence"
    )

    private Long id;
    private Long userId;
    @ManyToMany
    @JoinColumn(name="track_id")
    private Set<Track> tracks;

    public Favourite(Long id, Long userId, Set<Track> tracks) {
        this.id = id;
        this.userId = userId;
        this.tracks = tracks;
    }

    public Favourite(Long userId, Set<Track> tracks) {
        this.userId = userId;
        this.tracks = tracks;
    }

    public Favourite() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
