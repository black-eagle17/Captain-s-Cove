package com.group5;

import java.util.Scanner;

public class InputHandler {
  private final Scanner scnr = new Scanner(System.in); // input stream

  GameEvent readEvent() {
    String userInput = scnr.nextLine().trim().toLowerCase(); // read character input

    // check to see if user did not type anything
    if (userInput.isEmpty())
      return GameEvent.UNKNOWN;

    //check to see if it is only so we can quit
    if(userInput.length() == 1 && userInput.charAt(0) == 'q'){
        return GameEvent.QUIT;
    }

    String choice = userInput.substring(0, 2);
    return switch (choice) {
      case "1a" -> GameEvent.TRAVEL;
      case "1b" -> GameEvent.INVESTIGATE;
      case "1c" -> GameEvent.STAY;
      case "1d" -> GameEvent.TRACK;
      case "1e" -> GameEvent.GRAB;
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
      case "ll" -> GameEvent.LOOT;
      case "3a" -> GameEvent.HOLE;
      case "3b" -> GameEvent.CREW;
      case "4a" -> GameEvent.ATTEMPT;
      case "4b" -> GameEvent.READY;
      case "ff" -> GameEvent.ATTACK_CRAB;
      case "6a" -> GameEvent.STATS;
      default -> GameEvent.UNKNOWN;

    };
  }
}
