package com.group5;


public class Drawer {
    //draws ui to the screen
    public void draw(SceneState _sceneState, Player _player) {
        final int WIDTH = 60; // wrap text after 60 characters
        StringBuilder display = new StringBuilder(); // final output string


        // print rpg game name and display current scene name
        int dashes = Math.max(3, WIDTH - _sceneState.getTitle().length() - 1);
        display.append(_sceneState.getTitle()).repeat("─", dashes).append(_sceneState.getSceneName()).append("\n\n");

        // print the story prompt for the current scene
        for (String line : _sceneState.getStory().split("\n")){
            display.append("  ").append(line).append("\n");

        }

        // Player and enemy health stats
        display.repeat("─", WIDTH).append("\n\n").append(gameStatus("Player", _player.getHp(), 100, _player.getInventory())); // player and enemy status
        if(_sceneState.getEnemy() != null) {
            display.append(gameStatus(_sceneState.getEnemy(), enemy.getEnemyHp(), 100, "Massive Iron Claw")); //use gameStatus() to print enemy info if applicable
        }
        display.repeat("─", WIDTH).append("\n\n");

        // Choices
        for (int i = 0; i < _sceneState.getChoices().size(); i++) {
            display.append("  [").append(i + 1).append("] ")
                    .append(_sceneState.getChoices().get(i)).append("\n");
        }
        display.append("\n  > Choose: ");

        System.out.print(display);
        System.out.flush();
    }

    private String gameStatus(String name, int hp, int maxHp, String extra) {
        return "  " + padRight(name, 12) + " HP " + bar(hp, maxHp)
                + " " + hp + "/" + maxHp + "   " + extra + "\n";
    }
    private String bar(int hp, int maxHp) {
        final int BAR_LENGTH = 12;

        if (maxHp <= 0) return "-".repeat(BAR_LENGTH);

        int filled = (int) Math.round((double) hp / maxHp * BAR_LENGTH);
        filled = Math.clamp(filled, 0, BAR_LENGTH);

        if (hp > 0 && filled == 0) filled = 1;
        return "#".repeat(filled) + "-".repeat(BAR_LENGTH - filled);
    }

    private String padRight(String str, int width) {
        if (str.length() >= width) return str.substring(0, width);
        return str + " ".repeat(width - str.length());
    }
}
