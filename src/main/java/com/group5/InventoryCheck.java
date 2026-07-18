package com.group5;

public class InventoryCheck {
    private Dice dice; //dice object that contains the roll method

    //constructor
    public InventoryCheck(){
        this.dice = new Dice(); // init dice obj
    }

//below is the simplified method to return a dice roll. the conditional logic will be added outside of this method

    public int initialRoll(Player player) {

        int initialRoll = dice.rollDice();

       return initialRoll; }


    public int amuletBonus(Player player, int initialRoll){
        String inventory = player.getInventory(); // grab the string that contains the list of player inventory
        int finalD20 = 0;

        if (inventory.contains("Amulet")) {
            finalD20 = initialRoll + 3;// get the random dice roll num and add 3 because of the Amulet
        } else {
            finalD20 = initialRoll;
        }

        System.out.println("You rolled -> " + initialRoll);
        if(finalD20 != initialRoll){
            System.out.println("with loot bonus -> +3");
        }
        System.out.println("for a total -> " + finalD20);

        return finalD20;
    }
}









