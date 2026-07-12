package com.group5;

public class FinalBossScene implements Scene{
    private SceneState _sceneState;
    private boolean complete;
    private Scene nextScene;


    public FinalBossScene(){
        this._sceneState = new SceneState();
        _sceneState.setSceneName("Final Boss Scene");
        _sceneState.setStory(
                "The strange markings on the door in front of you begin to glow as the door melts away in front of your eyes.\n" +
                        "You enter a large coliseum and are stunned by the roar of an overwhelmingly large crowd of spectators.\n" +
                "“Where the hell am I ?” You think to yourself. But you are quickly interrupted by a thunderous voice.\n"+
                "“Welcome traveler! It is nice to see you have made it to tonight’s festivities”.\n"+
        "“HELP! OVER HERE!” Your head is spinning as you quicky surveil the room and notice some of your crew mates had been captured.\n"+
        "The ground rumbles with such force it radiates up your legs and your teeth begin to chatter.\n"+
                "A GIANT crab bursts from the dirt and snaps its large claws with a deafening boom.\n" +
                "Your eyes dart between your crewmates huddled together, and the hole in the ground where the crab emerged; could this be the way out?\n" +
        "You look up again to see one of the massive claws swinging towards you for a strike!\n"
        );
        _sceneState.getChoices().add("(3a)Dash towards the hole in the ground");
        _sceneState.getChoices().add("(3b)Dash towards your crewmates");

    }

    @Override
    public void handleEvent(GameEvent event, Player player) {
 switch(event) {
     case HOLE -> {
         System.out.println("In an act of pure desperation you roll towards the hole and succesfully drop in.\n"+
                 "You are then crushed by an overwhelmingly powerful river of sand.(PLAYER DIES!)");
         player.setPlayerDead(); // player is dead, don't need to return a new scene
     }
     case CREW -> {

         switch (event){
             case ATTEMPT -> {
                 /*DICE ROLL ENCOUNTER pass/fail for breaking lock. either way player does not die
                 if you succeed dice roll the lock breaks and your crew mates disperse throughout battlefield,
                 if you fail your crew remains in the cage and you prepare to fight the crab
                  */
                 //TODO: ADD THE COMBAT FOR FINAL BOSS HERE
             }
             case READY -> {
                 System.out.print("Saving your crew crosses your mind,\n" +
                         "but you realize that staying alive yourslef must come first before saving your crew.\n"+
                         "You brush the dirt off of your shirt and prepare for combat.\n"
                         );
                 //TODO: ADD THE COMBAT FOR FINAL BOSS HERE
             }
         }
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
