package oop_recap;

public interface Movement {

    default String move() {
        return "Swiggity Swoggty";
    }
}
