package dk.kea.trash_api.controllers;

import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class TrashController {

    List<String> sinList = Arrays.asList("Glottony", "Lust", "Greed", "Wrath", "Sloth", "Envy", "Pride");

    @GetMapping("/")
    public String message() {
        return "Hello World";
    }

    @GetMapping("/clock")
    public LocalTime clock() {
        return LocalTime.now();
    }

    @GetMapping("/sin/{number}")
    public String sevenDeadlySins(@PathVariable int number) {

        try {
            return sinList.get(number);
        } catch (Exception e) {
            return "Not a sin";
        }
    }

    @GetMapping("/trash")
    public String trash(@RequestParam(required = false) String trash) {
        return trash;
    }
}
