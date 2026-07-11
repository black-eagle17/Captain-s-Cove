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




            default -> GameEvent.UNKNOWN;

        };
    }
}
