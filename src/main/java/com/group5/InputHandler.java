package com.group5;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scnr = new Scanner(System.in); //input stream

    GameEvent readEvent(){
        String line = scnr.nextLine().trim().toLowerCase(); //read character input

        //check to see if user did not type anything
        if(line.isEmpty()) return GameEvent.UNKNOWN;

        char key = line.charAt(0);
        return switch(key){
            case 'g' -> GameEvent.GRAB;
            case 'q' -> GameEvent.QUIT;
            case 'a' -> GameEvent.ATTACK;
            case 't' -> GameEvent.TRAVEL;
            case 'i' -> GameEvent.INVESTIGATE;
            case 'e' -> GameEvent.EAT;
            case 'l' -> GameEvent.LEFT;
            case 'c' -> GameEvent.CENTER;
            case 'r' -> GameEvent.RIGHT;
            case 's' -> GameEvent.STAY;
            case 'k' -> GameEvent.TRACK;
            case 'n' -> GameEvent.SING ;
            case 'f' -> GameEvent.FLEE;


            default -> GameEvent.UNKNOWN;

        };
    }
}
