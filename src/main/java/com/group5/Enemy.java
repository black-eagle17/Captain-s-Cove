package com.group5;

public class Enemy {
  private String name;
  private int enemyHealth;
  private boolean isEnemyDead;
  private String inventory;

  // ctor
  public Enemy(String name) {
    this.name = name;
    this.enemyHealth = 100;
    this.isEnemyDead = false;
    this.inventory = "Massive Iron Claw";
  }

  // check the isEnemyDead flag and return its value
  public boolean isEnemyDead() {
    return isEnemyDead;
  }

  // update isEnemyDead flag to true
  public void setEnemyDead() {
    this.isEnemyDead = true;
  }

  // returns the current enemy health
  public int getEnemyHp() {
    return enemyHealth;
  }

  // reduce overall enemy health
  public void dealDamage(int damageAmt) {
    if (!isEnemyDead()) {
      enemyHealth -= damageAmt;
    }
  }

  // return the enemy inventory
  public String getInventory() {
    return inventory;
  }

  // return enemy name
  public String getName() {
    return name;
  }

  // add to enemy inventory
  public void addItem(String item) {
    inventory += " " + item;
  }
}
