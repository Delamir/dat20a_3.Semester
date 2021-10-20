package edu.kea.paintings.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kea.paintings.DTO.ArtistDTO;
import edu.kea.paintings.models.Artist;
import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.ArtistRepository;
import edu.kea.paintings.repositories.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Paintings {

    @Autowired
    PaintingRepository paintings;

    @Autowired
    ArtistRepository artists;

    @GetMapping("/paintings")
    public Iterable<Painting> getPaintings() {
        return paintings.findAll();
    }

    @GetMapping("/paintings/{id}")
    public Painting getPainting(@PathVariable Long id) {
        return paintings.findById(id).get();
    }

    @GetMapping("/paintings/timeline")
    public List<Painting> getPaintingByArtistAndYear(@RequestParam String artist, @RequestParam int year) {
        return paintings.findPaintingsByArtistAndYear(artist, year);
    }

    @GetMapping("/paintings/priceabove/{price}")
    public List<Painting> getPaintingsAboveACertainPrice(@PathVariable double price) {
        return paintings.findPaintingsAboveACertainPrice(price);
    }


    @PostMapping("/paintings")
    public Painting addPainting(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Painting paintingToCreate = mapper.readValue(body, Painting.class);

        Iterable<Long> artistsIds = mapper.readValue(body, ArtistDTO.class).artistsIds;

        List<Artist> foundArtists = artists.findAllById(artistsIds);

        paintingToCreate.setArtists(foundArtists);

        return paintings.save(paintingToCreate);
    }

    @PutMapping("/paintings/{id}")
    public String updatePainting(@PathVariable Long id, @RequestBody Painting painting) {
        if (paintings.existsById(id)) {
            painting.setId(id);
            paintings.save(painting);
            return "Painting was created";
        } else {
            return "Painting not found";
        }
    }

    @PatchMapping("/paintings/{id}")
    public String patchPainting(@PathVariable Long id, @RequestBody Painting painting) {
        return paintings.findById(id).map(foundPainting -> {
            if (painting.getArtist() != null) foundPainting.setArtist(painting.getArtist());
            if (painting.getPrices() != 0) foundPainting.setPrices(painting.getPrices());
            if (painting.getTitle() != null) foundPainting.setTitle(painting.getTitle());
            if (painting.getGenre() != null) foundPainting.setGenre(painting.getGenre());
            if (painting.getYear() != 0) foundPainting.setYear(painting.getYear());

            paintings.save(foundPainting);
            return "Painting updated";
        }).orElse("Painting not found");
    }

    @DeleteMapping("/paintings/{id}")
    public void deletePainting(@PathVariable Long id) {
        paintings.deleteById(id);
    }

}
