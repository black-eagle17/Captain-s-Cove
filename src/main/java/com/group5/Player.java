package com.group5;

public class Player {

  private int playerHealth;
  private boolean isPlayerDead;
  private String inventory;
  private int lootPoints;
  private boolean wantToUseLoot;
  private boolean canUseLoot;
  private  int extraDmg;

  // ctor
  public Player() {
    this.playerHealth = 100;
    this.isPlayerDead = false;
    this.inventory = "";
    this.lootPoints = 0;
    this.wantToUseLoot = false;
    this.canUseLoot = true;
    this.extraDmg = 0;
  }

  // check the isPlayerDead flag and return its value
  public boolean isPlayerDead() {
    return isPlayerDead;
  }

  // update isPlayerDead flag to true
  public void setPlayerDead() {
    this.isPlayerDead = true;
  }

  // returns the current player health
  public int getHp() {
    return playerHealth;
  }

  // reduce overall player health
  public void dealDamage(int enemyDmgAmt) {
    if (!isPlayerDead()) {
        // check if we haven't use loot item yet then deal damage based on loot
      if(wantToUseLoot && canUseLoot){
          lootPoints = determineLoot(enemyDmgAmt);
          playerHealth -= lootPoints;
          canUseLoot = false;
      }else{
          //just do a regular damage
          playerHealth -= enemyDmgAmt;
      }
    }
  }

  //make sure we use loot item once
  public void oneShotLootItem(){
      wantToUseLoot = true;
  }
  // deals extra damage to enemy based on vial of blue liquid
    public int extraDmg(){
      if(wantToUseLoot)
      {
      return extraDmg;
      }
      else return 0;
    }

  // return the players inventory
  public String getInventory() {
    return inventory;
  }

  // add to players inventory
  public void addItem(String item) {
    inventory += " " + item;
  }


  private int determineLoot(int dmgAmt){//TODO:add item prompts based on the inventory and what we used
      if(inventory.contains("helmet")){
      lootPoints = dmgAmt - 8;
      }else if(inventory.contains("vial of blue liquid")){
          extraDmg = 10;
          lootPoints = dmgAmt;
          System.out.println("You will damage the enemy by an extra 10 points");
      }else if(inventory.contains("boots")){
          lootPoints = 0;
      }


      return lootPoints;
  }
}
