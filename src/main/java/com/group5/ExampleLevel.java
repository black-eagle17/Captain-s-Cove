package com.group5;

public class ExampleLevel implements Level {

    private Level nextLevel = null; // stores the next level to be instantiated
    private boolean complete = false;
    private int enemyHealth = 10;


    @Override
    public void onEnter() {
        System.out.println("The cold salt water hitting your face is what wakes you first, the crab pinching your foot is what gets you to jolt up to your\n" +
                "feet!");
    }

    @Override
    public void handleEvent(GameEvent event) {
        switch (event){
            case TRAVEL ->{
                System.out.println("You have chosen to travel");
                complete = true;
                nextLevel = new ExampleLevel();// should be a level based on the previous choice. In this case, I only have one level, so I just return it
            }
            case INVESTIGATE ->{
                System.out.println("You have chosen to investigate the ship");
                complete = true;
                nextLevel = new ExampleLevel(); // should be a level based on the previous choice. In this case, I only have one level, so I just return it
            }
            default -> {
            }
        }
    }

    @Override
    public void render() {

    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public Level getNextLevel() {

        return nextLevel;
    }
}
