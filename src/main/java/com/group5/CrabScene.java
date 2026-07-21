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
    _sceneState.getChoices().add("(ll) Use loot");
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
        int crabRoll = _dice.rollDice();

        System.out.println("Player rolled a " + playerRoll);
        System.out.println("Crab rolled a " + crabRoll);




        //determine if enemy is using special capabalities..need to print out the statement if crab used the claw
        int crabClawRoll = _dice.rollCrabDice();
        if(crabClawRoll > 30)
        {
            crabClawRoll = 8;
            System.out.println("Crab used Massive Iron Claw for +8 damage");
        }else{
            crabClawRoll =0;
        }
        //subtract health from player
        player.dealDamage(crabRoll + crabClawRoll);

        //subtract health from enemy
        crab.dealDamage(player.extraDmg() + playerRoll);


        //check if player or enemy won/died
        if(player.getHp() <=0 && crab.getEnemyHp() > 0 )
        {
            //should set scene to a losing scene
          player.setPlayerDead();
        }
        else if(player.getHp()>0 && crab.getEnemyHp()<=0){
           // should set scene to a winning scene
          System.out.println("Winnner");
        }


        return;
      }
      case LOOT -> {
        player.oneShotLootItem();
        System.out.println("Great choice, using loot item");
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


  }

