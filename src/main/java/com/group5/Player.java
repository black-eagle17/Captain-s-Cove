package com.group5;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerHealth;
    private boolean isPlayerDead;
    private ArrayList<String> inventory;
    private int dexterity;
    private int armor;

    public Player(){
        this.playerHealth = 100;
        this.isPlayerDead = false;
        this.inventory = new ArrayList<String>();
    }

    public boolean isPlayerDead(){

        return isPlayerDead;
    }
    public void setPlayerDead(){
        this.isPlayerDead = true;
    }
    public int getHp(){
        return playerHealth;
    }
}
