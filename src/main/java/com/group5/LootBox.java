package com.group5;

public class LootBox {
    public String [] loot = {"helmet", "boots", "vial of blue liquid"};

    public int diceRoll(){
        return (int) (Math.random() * 20);

    }




   public String determineLoot(int diceValue) {
        String lootItem = " ";
        if (diceValue > 0 && diceValue < 6) {
            lootItem = this.loot[0];
        }
        else if (diceValue >= 6 && diceValue <= 12) {
            lootItem = this.loot[1];
        }
        else{
            lootItem = this.loot[2];
        }

        return lootItem;

    }
}
