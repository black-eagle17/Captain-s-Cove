package com.group5;

public class InventoryCheck {

    private int D20() {
        return (int) (Math.random() * 20);
    }


    public int evaluateInventory(Player player) {
        String inventory = player.getInventory();
        int finalD20 = 0;
        if (player.getInventory().contains("Katana")) {
            finalD20 = D20() + 3;
            System.out.println("You rolled a " + finalD20);
            // add script and advance scene
        }
        else if (player.getInventory().contains("Amulet")) {
            finalD20 = D20() + 3;
            System.out.println("You rolled a " + finalD20);
            // add script and advance scene
        } else {
            finalD20 = D20();
            System.out.println("Blah blah blah " + finalD20);
            // add script and advance scene
        }
        return finalD20;
    }
public boolean diceResult(int finalD20){
        boolean diceResult;
        if(finalD20 < 10){
            return diceResult = false;
        }
        else {
            return diceResult = true;
        }
}

}
