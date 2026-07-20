package com.group5;

public class CrabScene implements Scene {

  private SceneState _sceneState;
  private boolean complete;
  private Scene nextScene;
  private Enemy _crab;
  private Dice _dice;

  public CrabScene() {
    this._sceneState = new SceneState();
    _sceneState.setSceneName("Boss Crab Scene");
    _crab = new Enemy("CRAB 5");
    _sceneState.setEnemy(_crab.getName());
    _sceneState.setStory(
        """
                CRAB prompt, not sure what to put
            """);

    _sceneState.getChoices().add("(ff) Fight crab");
    _sceneState.getChoices().add("(1f) Use loot");
    _dice = new Dice();
  }

  @Override
  public void handleEvent(GameEvent event, Player player) {
    switch (event) {
      case ATTACK_CRAB -> {
        // should have some more prompts
        System.out.println("You look up again to see one of the massive claws swinging towards you for a strike!\n");

        // roll dice for the player
        int playerRoll = _dice.rollDice();

        // roll dice for the enemy
        int enemyRoll = _dice.rollDice();

        // both entity should deal damage (What is the purpose of the dice roll?)

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
}
