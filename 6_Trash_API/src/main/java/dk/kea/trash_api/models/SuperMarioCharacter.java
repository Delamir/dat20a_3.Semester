package dk.kea.trash_api.models;

public class SuperMarioCharacter {

    private String character;

    public SuperMarioCharacter(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }
}
