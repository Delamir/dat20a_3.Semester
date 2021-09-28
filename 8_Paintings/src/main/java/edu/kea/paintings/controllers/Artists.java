package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Artist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Artists {

    @GetMapping("/artists")
    public Artist getArtists() {
        return null;
    }

    @GetMapping("/artists/{id}")
    public Artist getArtist(@PathVariable int id) {
        return null;
    }

    @PostMapping("/artists")
    public Artist createArtist() {
        return null;
    }
}
