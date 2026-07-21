package com.group5;

public class InventoryCheck {
    private Dice dice; //dice object that contains the roll method
    private int initialRoll;
    //public static ArrayList<Integer> _inventory = new ArrayList<Integer>()
    //constructor
    public InventoryCheck(){
        this.dice = new Dice(); // init dice obj
    }

//below is the simplified method to return a dice roll. the conditional logic will be added outside of this method
    //public void removeItem


    public void initialRoll() {

         initialRoll = dice.rollDice();
    }


    public int amuletBonus(Player player){
        String inventory = player.getInventory(); // grab the string that contains the list of player inventory
        initialRoll();
        int finalD20 = initialRoll;


        if (inventory.contains("Amulet")) {
            finalD20 = finalD20 + 3;// get the random dice roll num and add 3 because of the Amulet
        }

        System.out.println("You rolled -> " + initialRoll);
        if(finalD20 != initialRoll){
            System.out.println("with loot bonus -> +3");
        }
        System.out.println("for a total -> " + finalD20 );

        return finalD20;
    }
    public int swordBonus(Player player){
        String inventory = player.getInventory(); // grab the string that contains the list of player inventory
        initialRoll();
        int finalD20 = initialRoll;

        if (inventory.contains("Katana")) {
            finalD20 = finalD20 + 3;// get the random dice roll num and add 3 because of the Amulet
        }

        System.out.println("You rolled -> " + initialRoll);
        if(finalD20 != initialRoll){
            System.out.println("with loot bonus -> +3");
        }
        System.out.println("for a total -> " + finalD20);

        return finalD20;
    }
}
