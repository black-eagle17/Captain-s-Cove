package com.group5;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scnr = new Scanner(System.in); //input stream

    GameEvent readEvent(){
        String userInput = scnr.nextLine().trim().toLowerCase(); //read character input

        //check to see if user did not type anything
        if(userInput.isEmpty()) return GameEvent.UNKNOWN;

       String choice = userInput.substring(0,2);
        return switch(choice){
            case "1a" -> GameEvent.TRAVEL;
            case "1b" -> GameEvent.INVESTIGATE;
            case "1c" -> GameEvent.STAY;
            case "1d" -> GameEvent.TRACK;
            case "1e"-> GameEvent.GRAB;
            case "1f" -> GameEvent.INSPECT;
            case "1g" -> GameEvent.EAT;
            case "2a" -> GameEvent.LEFT;
            case "2b" -> GameEvent.CENTER;
            case "2c" -> GameEvent.RIGHT;
            case "2d" -> GameEvent.ATTACK;
            case "2e" -> GameEvent.SING;
            case "2f" -> GameEvent.FLEE;
            case "2g" -> GameEvent.SWING;
            case "2h" -> GameEvent.EXPLAIN;
            default -> GameEvent.UNKNOWN;

        };
    }
}
