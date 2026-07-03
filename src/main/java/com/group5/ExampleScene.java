package com.group5;

public class ExampleScene implements Scene {

    private Scene nextScene = null; // stores the next level to be instantiated
    private boolean complete = false;
    private int enemyHealth = 10;


    @Override
    public void handleEvent(GameEvent event) {

    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public Scene getNextLevel() {

        return nextScene;
    }

    @Override
    public SceneState getSceneState() {
        return null;
    }
}
