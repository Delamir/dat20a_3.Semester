package OOP_Recap;

public class Octopus extends Animal implements Movement {

    public String activity(int activityNumber) {
        switch(activityNumber) {
            case 1:
                return "Swimming";
            case 2:
                return "Flopping";
            case 3:
                return "Eating";
            case 4:
                return "Swooshing";
            case 5:
                return "Swishing";
            case 6:
                return "Spraying ink";
            default:
                return "Sleeping";
        }
    }

    @Override
    public String move() {
        return "Swish Swosh";
    }
}
