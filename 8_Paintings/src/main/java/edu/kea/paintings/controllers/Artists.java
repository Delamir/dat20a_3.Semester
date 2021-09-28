package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Artist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Artists {

    @GetMapping("/artists")
    public Artist getArtists() {
        return null;
    }

}
