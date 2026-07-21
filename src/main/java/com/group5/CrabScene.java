package com.group5;

public class CrabScene implements Scene {

  private SceneState _sceneState;
  private boolean complete;
  private Scene nextScene;
  private Dice _dice;
  private boolean didUseLoot = false;

  public CrabScene() {
    this._sceneState = new SceneState();
    _sceneState.setSceneName("Boss Crab Scene");
    _sceneState.setStory(
        """
                CRAB prompt, not sure what to put
            """);

    _sceneState.getChoices().add("(ff) Fight crab");
    _sceneState.getChoices().add("(1f) Use loot");
    _dice = new Dice();
  }

  @Override
  public void handleEvent(GameEvent event, Player player, Enemy crab) {
    switch (event) {
      case ATTACK_CRAB -> {
        // should have some more prompts
        System.out.println("You look up again to see one of the massive claws swinging towards you for a strike!\n");

        // roll dice for the player
        int playerRoll = _dice.rollDice();

        // roll dice for the enemy
        int enemyRoll = _dice.rollDice();

        System.out.println("Player rolled a " + playerRoll);
        System.out.println("Enemy rolled a " + enemyRoll);

        //subtract health from enemy
        crab.dealDamage(playerRoll);

        //determine if enemy is using special capabalities
        int crabClawRoll = _dice.rollCrabDice();
        if(crabClawRoll > 30)
        {
            crabClawRoll = 8;
        }else{
            crabClawRoll =0;
        }

        //subtract health from player
        player.dealDamage(enemyRoll + crabClawRoll);

        checkLootItem()

        //check if player or enemy won/died
        if(player.getHp() <=0 && crab.getEnemyHp() > 0 )
        {
            //should set scene to a losing scene
        }
        else if(player.getHp()>0 && crab.getEnemyHp()<=0){
           // should set scene to a winning scene
        }


        return;
      }
      case USE_LOOT -> {
        System.out.println(
            "You take the Amulet and see it glow.\n ");
      }
      default -> System.out.println("Invalid key press");
    }
  }

  @Override
  public boolean isComplete() {
    return complete;
  }

  @Override
  public Scene getNextLevel() {
    return nextScene;
  }

  @Override
  public SceneState getSceneState() {
    return _sceneState;
  }

  public void checkLootItem(Player player, int amt){
      if(!didUseLoot){
          // check to see what loot we have and apply bonus
         // depending on item
         if(player.getInventory().contains("helmet")){
             System.out.println("You used a helmet, next hit from enemy will be decreased by +5 hp");
             player.blockDamage();
         }
      }
     return;
  }
}
