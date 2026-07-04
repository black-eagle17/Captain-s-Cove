package com.group5;

public interface Scene {
    void handleEvent(GameEvent event, Player player); //handle user input
    boolean isComplete(); //returns true if level is complete
    Scene getNextLevel(); //returns the next scene to load
    SceneState getSceneState(); // this method will return the current player/ enemy stats after a scene such as after an attack or combat
}
