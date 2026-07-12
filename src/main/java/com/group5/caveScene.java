package com.group5;

public class caveScene implements Scene {

    private SceneState _sceneState;
    private boolean complete;
    private Scene nextScene;
    private InventoryCheck itemCheck;

    public caveScene() {
        this._sceneState = new SceneState();
        this.itemCheck = new InventoryCheck();
        _sceneState.setSceneName("Cave Scene");
        _sceneState.setStory(
            "  The deeper and deeper you go, the darker and darker it gets.\n" +
                " Your feet are wary and your spirits are low. You slowly come upon lights.\n" +
                " A fire of some sort? No… magic? There are 3 tunnels, all glowing with a different color light.\n" +
                "on the left you smell the scent of fish down Blue tunnel, in the center you hear music down Purple tunnel,\n" +
                    " and to the right see shadows moving down Green tunnel "
        );
        _sceneState.getChoices().add("(2a)Blue Cave.");
        _sceneState.getChoices().add("(2b)Purple Cave.");
        _sceneState.getChoices().add("(2c)Green Cave.");
    }

    @Override
    public void handleEvent(GameEvent event, Player player) {
        switch (event) {
            case LEFT -> {
                System.out.println(
                    "You take one step into the blue cave and find yourself transported right back to the mouth of cave where you started.\n "
                );
                complete = true;
                nextScene = new caveScene(); //this should return the player back to the cave scene
            }
            case CENTER -> {
                complete = false;
                String sirenPrompt =
                    "Sirens!\n" +
                    "*Dice Roll Encounter\n" +
                    "You follow the sound of music along the tunnel and find yourself at a large indoor grotto.\n" +
                    " Dozens of heads pop up from the water.\n" +
                    "As you look into their beautiful purple eyes and hear the beautiful music floating around the walls of the cave, \n" +
                    "you realize you are surrounded by Sirens.\n" +
                    "One of the sirens rises from the water and you see an amulet dangling around the creature's lock neck.\n" +
                    " They speak, “Show us why you deserve to live and you will gain passage. Fail and perish.\n" +
                    "You’ve only got one turn at this, choose an action: Attack, Sing, Flee\n";

                _sceneState.setStory(sirenPrompt);
                _sceneState.setSceneName("Cave Scene => Sirens"); //set the updated  name of the scene.
                _sceneState.getChoices().clear(); //empty the choices list and add these new ones
                _sceneState.getChoices().add("(2d)Attack");
                _sceneState.getChoices().add("(2e)Sing");
                _sceneState.getChoices().add("(2f)Flee");

                /*This is where another switch case will happen to evaluate choices above and potentially
                will encounter dice roll if player does not flee
                 */

            }
            case RIGHT -> {

                String goblinPromt =   "Goblins!\n " +
                        "*Dice Roll Encounter\n" +
                        "You run down the green tunnel towards the shadows.\n " +
                        "Could it be your friends? Could it be their captors?\n" +
                        "You stop in your tracks to see a giant door.Guarding it, goblins. Like, a bunch of Goblins.\n" +
                        "The Goblins hiss at you before falling into formation, their swords pointed towards you.\n" +
                        "You’ve only got one turn at this, choose an action: Swing Sword, Explain yourself, Flee\n";


                _sceneState.setStory(goblinPromt);
                _sceneState.setSceneName("Cave Scene => Goblins"); //set the updated  name of the scene.
                _sceneState.getChoices().clear(); //empty the choices list and add these new ones
                _sceneState.getChoices().add("(2g)Swing Sword");
                _sceneState.getChoices().add("(2h)Explain yourself");
                _sceneState.getChoices().add("(2f)Flee");



            }
            case ATTACK -> {
                System.out.println("You have chosen to ATTACK!");
                int numRoll = itemCheck.evaluateInventory(player);
                if(numRoll < 10){
                    //output the player rolled number and set player dead
                    String output ="You lunge at the Siren and slip on the wet stones, hitting your head and being dragged into the dark water.";
                    System.out.println(output);
                    player.setPlayerDead();
                }
                else {
                    String output =
                    "You lunge at the siren and grab them, your arms wrapping\n" +
                    "around them as they are restrained. There is no need for violence, the fish person\n" +
                    "calmly muses. At least… not with us… You release your grip.\n" +
                    "I know who you are looking for.  A large whirlpool begins to form in front of you.\n" +
                    "Your friends are just through here. But beware, they are guarded by a beast. We are sworn not to intrude on it,\n" +
                    "lest it come for our own. But perhaps we can help you defeat it.\n";
                    _sceneState.setStory(output);
                    complete=true;
                    nextScene = new HallwayScene();
                }
            }

            case SING -> {
                System.out.println("You have chosen to sinnnnggggg....");
                int numRoll = itemCheck.evaluateInventory(player);
                if(numRoll < 10){
                    //output the player rolled number and set player dead
                    String output ="You clear your throat and sing. Terribly. The Mermaid in front of you sings and their amulet expels a purple shadow that engulfs you. Your skin turns to ash and your dead skeleton hits the floor ";
                    System.out.println(output);
                    player.setPlayerDead();
                }
                else {
                    String output =
                    " The sirens face softens in deep appreciation for your song. “I know who you are looking for.\n"+
                    "A large whirlpool begins to form in front of you. Your friends are just through here. But beware, they\n" +
                    "are guarded by a beast. We are sworn not to intrude on it, lest it come for our own. But perhaps we can help you defeat it.\n";
                    _sceneState.setStory(output);
                    complete = true;
                    nextScene = new HallwayScene();
                }
            }

            //cases for the goblin
            case SWING -> {
                System.out.println("You have chosen to SWING YOUR SWORD!");
                int numRoll = itemCheck.evaluateInventory(player);
                if(numRoll < 10){
                    //output the player rolled number and set player dead
                    String output ="You lunge forward and slip on the damp cave floor, falling backwards as if there were a banana peel. You look like a fool. As youre on the ground, the Goblins swarm you.";

                    System.out.println(output);
                    player.setPlayerDead();
                }
                else {
                    String output =
                    "You're stronger than a toddler!\n" +
                    "You lunge at the Goblin closest and strike true, knocking it back a few feet to the ground.\n"+
                    "It didn’t take much, they're tiny guys. The other goblins  look at you and revere you as the strongest\n"+
                    "in the room. The goblin on the ground crawls towards you, “Oh please, help us defeat the beast beyond\n"+
                    "this door! We have been able to keep it contained but have lost too many trying to fight it! It killed\n"+
                    "one of your men when you crashed, but together we can free your friends and ours!";
                    _sceneState.setStory(output);
                    complete = true;
                    nextScene = new HallwayScene();
                }
            }

            case EXPLAIN ->{
                System.out.println("You have chosen to EXPLAIN YOUR SELF!");
                int numRoll = itemCheck.evaluateInventory(player);
                if(numRoll < 10){
                    //output the player rolled number and set player dead
                    String output ="You lunge forward and slip on the damp cave floor, falling backwards as if there were a banana peel. You look like a fool. As youre on the ground, the Goblins swarm you.";

                    System.out.println(output);
                    player.setPlayerDead();
                }
                else {
                    String output =
                    "You calmly explain that you mean no harm and that you are simply looking for your crew.\n" +
                    "The Goblin closest to you looks to his group and then back at you before dropping to its knees.\n"+

                     "Oh please, help us defeat the beast beyond this door! We have been able to keep it out of this tunnel\n" +
                     "but have lost too many trying to fight it! It killed one of your men when you crashed, but together\n" +
                      "we can free your friends and ours!";
                    _sceneState.setStory(output);
                    complete = true;
                    nextScene = new HallwayScene();
                }

            }

            case FLEE -> {
                System.out.println("You have chosen to flee like a coward!\n" +
                        " You consequently find yourself back at the cave mouth from whence you came.");
                complete = true;
                nextScene = new caveScene();
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
