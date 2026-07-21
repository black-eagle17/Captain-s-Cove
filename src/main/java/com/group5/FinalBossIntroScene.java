package com.group5;

public class FinalBossIntroScene implements Scene {
  private SceneState _sceneState;
  private boolean complete;
  private Scene nextScene;

  public FinalBossIntroScene() {
    this._sceneState = new SceneState();
    _sceneState.setSceneName("Final Boss Scene");
    _sceneState.setStory(
        "The strange markings on the door in front of you begin to glow as the door melts away in front of your eyes.\n"
            +
            "You enter a large coliseum and are stunned by the roar of an overwhelmingly large crowd of spectators.\n" +
            "“Where the hell am I ?” You think to yourself. But you are quickly interrupted by a thunderous voice.\n" +
            "“Welcome traveler! It is nice to see you have made it to tonight’s festivities”.\n" +
            "“HELP! OVER HERE!” Your head is spinning as you quickly surveil the room and notice some of your crew mates had been captured.\n"
            +
            "The ground rumbles with such force it radiates up your legs and your teeth begin to chatter.\n" +
            "A GIANT crab bursts from the dirt and snaps its large claws with a deafening boom.\n" +
            "Your eyes dart between your crewmates huddled together, and the hole in the ground where the crab emerged; could this be the way out?\n"
            +
            "You look up again to see one of the massive claws swinging towards you for a strike!\n");
    _sceneState.getChoices().add("(3a)Dash towards the hole in the ground");
    _sceneState.getChoices().add("(3b)Dash towards your crewmates");

  }

  @Override
  public void handleEvent(GameEvent event, Player player, Enemy _enemy) {
    switch (event) {
      case HOLE -> {
        System.out.println("In an act of pure desperation you roll towards the hole and successfully drop in.\n" +
            "You are then crushed by an overwhelmingly powerful river of sand.(PLAYER DIES!)");
        player.setPlayerDead(); // player is dead, don't need to return a new scene
      }
      case CREW -> {
        _sceneState.setStory("You drop to the floor and log over to your crew.\n" +
            "The massive claw whizzes by your head, and snaps with a lethal force.\n" +
            "Your crew mates are locked in a small rusty cage with a worn pad lock.\n " +
            "You spot a small boulder next to the cage that could potentially break them free.\n" +
            "Knowing there is an angry murderous crab behind you, you have to decide fast. \n");

        _sceneState.getChoices().clear();
        _sceneState.getChoices().add("(4a)Attempt to free your crewmates");
        _sceneState.getChoices().add("(4b)Ignore crewmates and prepare to fight the crab");

      }
      case ATTEMPT -> {
        System.out.println("You chose to swing at the lock.");
        Dice dice = new Dice();
        int roll = dice.rollDice();

        System.out.println("you swing at the lock");
        System.out.println("you rolled a " + roll + ".");
        if (roll >= 10) {
          System.out.println("You shattered the lock.");
        }
        else if (roll < 10) {
          System.out.println("The lock did not break.");
        }
        nextScene = new CrabScene();
        complete = true;
      }
      case READY -> {
        System.out.print("Saving your crew crosses your mind,\n" +
            "but you realize that staying alive yourself must come first before saving your crew.\n" +
            "You brush the dirt off of your shirt and prepare for combat.\n");
        nextScene = new CrabScene();
        complete = true;

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
