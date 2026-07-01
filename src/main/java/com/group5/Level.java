package com.group5;

public interface Level {
    void onEnter(); // prints the prompt message for each scene
    void handleEvent(GameEvent event); //handle user input
    void render(); //prints player health and other choices
    boolean isComplete(); //returns true if level is complete
    Level getNextLevel();
}
