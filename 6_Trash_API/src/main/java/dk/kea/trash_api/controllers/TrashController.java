package dk.kea.trash_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

@RestController
public class TrashController {

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

        switch(number) {
            case 1: return "Glottony";
            case 2: return "Lust";
            case 3: return "Greed";
            case 4: return "Wrath";
            case 5: return "Sloth";
            case 6: return "Envy";
            case 7: return "Pride";
            default: return "Not a Sin";
        }
    }
}
