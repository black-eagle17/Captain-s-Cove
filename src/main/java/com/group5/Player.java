package com.group5;

public class Player {

    private int playerHealth;
    private boolean isPlayerDead;
    private String inventory;

    //ctor
    public Player() {
        this.playerHealth = 100;
        this.isPlayerDead = false;
        this.inventory = "";
    }

    //check the isPlayerDead flag and return its value
    public boolean isPlayerDead() {
        return isPlayerDead;
    }

    //update isPlayerDead flag to true
    public void setPlayerDead() {
        this.isPlayerDead = true;
    }

    //returns the current player health
    public int getHp() {
        return playerHealth;
    }

    //reduce overall player health
    public void dealDamage(int damageAmt) {
        if (!isPlayerDead()) {
            playerHealth -= damageAmt;
        }
    }

    //return the players inventory
    public String getInventory() {
        return inventory;
    }

    //add to players inventory
    public void addItem(String item) {
        inventory += " " + item;
    }
}
