package com.group5;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scnr = new Scanner(System.in); //input stream

    GameEvent readEvent(){
        System.out.println("> "); // prompt
        String line = scnr.nextLine().trim().toLowerCase();

        //check to see if user did not type anything
        if(line.isEmpty()) return GameEvent.UNKNOWN;

        char key = line.charAt(0);
        return switch(key){
            case 'q' -> GameEvent.QUIT;
            case 'a' -> GameEvent.ATTACK;
            case 't' -> GameEvent.TRAVEL;
            case 'i' -> GameEvent.INVESTIGATE;
            default -> GameEvent.UNKNOWN;

        };
    }
}
