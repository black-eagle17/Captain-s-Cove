package com.group5;

public class Enemy {
    private int enemyHealth;
    private boolean isEnemyDead;
    private String inventory;

    //ctor
    public Enemy() {
        this.enemyHealth = 100;
        this.isEnemyDead = false;
        this.inventory = "";
    }

    //check the isPlayerDead flag and return its value
    public boolean isEnemyDead() {
        return isEnemyDead;
    }

    //update isPlayerDead flag to true
    public void setEnemyDead() {
        this.isEnemyDead = true;
    }

    //returns the current enemy health
    public int getEnemyHp() {
        return enemyHealth;
    }

    //reduce overall enemy health
    public void dealDamage(int damageAmt) {
        if (!isEnemyDead()) {
            enemyHealth -= damageAmt;
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
