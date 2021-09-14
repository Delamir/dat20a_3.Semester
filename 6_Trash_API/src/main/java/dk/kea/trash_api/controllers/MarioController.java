package dk.kea.trash_api.controllers;

import dk.kea.trash_api.models.SuperMarioCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarioController {

    SuperMarioCharacter marioCharacter = new SuperMarioCharacter("Luigi");

    @GetMapping("/supermario/characters")
    public SuperMarioCharacter mario() {
        return marioCharacter;
    }
}
