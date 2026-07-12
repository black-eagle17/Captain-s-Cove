package com.group5;

public class InventoryCheck {
    private Dice dice; //dice object that contains the roll method

    //constructor
    public InventoryCheck(){
        this.dice = new Dice(); // init dice obj
    }

    public int evaluateInventory(Player player) {
        String inventory = player.getInventory(); // grab the string that contains the list of player inventory
        int finalD20 = 0;
        if (inventory.contains("Katana")) {
            finalD20 = dice.rollDice() + 3; // get the random dice roll num and add 3 because of the katana
        }
        else if (inventory.contains("Amulet")) {
            finalD20 = dice.rollDice() + 3;// get the random dice roll num and add 3 because of the Amulet
        } else {
            finalD20 = dice.rollDice();
        }
        return finalD20;
    }
}
