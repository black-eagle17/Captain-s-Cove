package com.group5;

import javax.swing.plaf.basic.BasicListUI;
import java.util.List;

public class Application {

    private final InputHandler inputHandler; //this will be responsible for grabbing input from the user and converting it into a specific type of event/
    private Level currLevel;
    private boolean running = true;

    //ctor
    public Application(Level start_level) {
        currLevel = start_level;
        inputHandler = new InputHandler();
    }

    //main game loop that advances level and handle user input
    public void run() {
        currLevel.onEnter(); //calls the current level onEnter method that will display prompt/puzzle and story to the user

        //actual game loop
        while (running) {
            currLevel.render(); //output current level state such as player health and enemy health

            GameEvent event = inputHandler.readEvent(); //grab input from the keyboard and decode which key was pressed and then turn it into an event

            //quit the game if QUIT event is detected by setting running to false
            if (event == GameEvent.QUIT) {
                running = false;
                break;
            }

            //dispatch event to current level if we did not quit the game
            currLevel.handleEvent(event);

            //check that we met the criteria for completing the scene or player died
            if (currLevel.isComplete()) {
                advanceLevel(); //can I advance to the next level (am i dead or not)
            }

        }
        System.out.println("GAME OVER!!! YOU LOST");
    }

    private void advanceLevel() {
        Level next = currLevel.getNextLevel();
        if (next == null) {
            running = false; //quit if you can't advance to the next level, basically dead!
            return;
        } else {
            currLevel = next ; //set the next level/scene
            currLevel.onEnter();
        }
    }
}
