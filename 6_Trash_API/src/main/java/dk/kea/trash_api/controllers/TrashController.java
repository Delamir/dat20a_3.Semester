package dk.kea.trash_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
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
}
