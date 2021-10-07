package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Paintings {

    @Autowired
    PaintingRepository paintings;

    @GetMapping("/paintings")
    public Iterable<Painting> getPaintings() {
        return paintings.findAll();
    }

    @GetMapping("/paintings/{id}")
    public Painting getPainting(@PathVariable Long id) {
        return paintings.findById(id).get();
    }

    @PostMapping("/paintings")
    public Painting createPainting(@RequestBody Painting painting) {
        // don't allow the client to overwrite the id
        painting.setId(null);
        return paintings.save(painting);
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
