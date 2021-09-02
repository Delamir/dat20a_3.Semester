package OOP_Recap;

import java.util.Random;

public class Octopus extends Animal implements Movement {

    Random random = new Random();
    GameOfOctopus game = new GameOfOctopus();

    public void makeDoActivity() {
        while (true) {
            String activity = selectActivity();
            System.out.println(activity);
            if(activity.equals("Mate")) {
                System.out.println("Otto is a horny beast");
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String selectActivity() {

        int activityNumber = random.nextInt(10) + 1;

        switch(activityNumber) {
            case 1:
                return "Mate";
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
