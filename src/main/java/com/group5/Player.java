package com.group5;

public class Player {

  private int playerHealth;
  private boolean isPlayerDead;
  private String inventory;
  private int lootPoints;
  private boolean didUseLoot;
  private boolean canUseLoot;

  // ctor
  public Player() {
    this.playerHealth = 100;
    this.isPlayerDead = false;
    this.inventory = "";
    this.lootPoints = 0;
    this.didUseLoot = false;
    this.canUseLoot = true;
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
      if(didUseLoot && canUseLoot){
          lootPoints = determineLoot(enemyDmgAmt);
          playerHealth+=lootPoints;
          System.out.println("You got " + lootPoints + " loot points which will aid in your fight");
          canUseLoot = false;
      }else{
          //just do a regular damage
          playerHealth -= enemyDmgAmt;
      }
    }
  }

  //make sure we use loot item once
  public void oneShotLootItem(){
      didUseLoot = true;
  }

  // return the players inventory
  public String getInventory() {
    return inventory;
  }

  // add to players inventory
  public void addItem(String item) {
    inventory += " " + item;
  }


  private int determineLoot(int dmgAmt){
      if(inventory.contains("helmet")){
          lootPoints = 5;
      }else if(inventory.contains("vial of blue liquid")){
          lootPoints = 10;
      }else if(inventory.contains("boot")){
          lootPoints = dmgAmt;
      }


      return lootPoints;
  }
}
