package com.group5;

public class ShipScene implements Scene{
    private SceneState _sceneState;
    private boolean complete;
    private  Scene nextScene;

    public ShipScene(){
        this._sceneState = new SceneState();
        _sceneState.setSceneName("Ship scene");
        _sceneState.setStory(
                """
                        “What happened to my crew?”
                        You use all your might to swim to *The Artemis*, your prized fishing vessel.
                        You make your way onto the boat and find a skeleton!
                        By God, how long has it been? You check the body and see it its clothes match of one of your crewmates, Harry.
                        The poor bastard. He has a small sword in his chest.
                        In his hand, a strange Amulet. And next to him… a tuna sandwich- fresher than Harry for sure but questionable.
      
                        """
        );

        _sceneState.getChoices().add("(G)rab the sword.");
        _sceneState.getChoices().add("(I)nvestigate the Amulet");
        _sceneState.getChoices().add("(E)at fish sandwich");
    }

    @Override
    public void handleEvent(GameEvent event, Player player) {
        switch (event){
            case GRAB ->{
                System.out.println("You grab the sword and realize it is rather small. The green handle would fit in the hand of a child and the short blade has writing you do not understand." +
                        "*Player earns +3 to strength and dexterity!* You are filled with determination as you enter the shell to investigate who could have killed Harry");

                //WE NEED TO ADD +3 TO PLAYER STRENGTH AND DEX HERE

                complete = true;
                nextScene = new IntroScene();// should be a level based on the previous choice. In this case, I only have one level, so I just return it
            }
            case INVESTIGATE ->{
                System.out.println("You take the Amulet and see it glow. *Player earns +2 to performance and charisma! " +
                        "You’re tempted to open it but you look at the far-too-aged Harry and decide against it. " +
                        "You are increasingly curious about what mystical events occurred here and take your first step into the shell to find answers.");
                //WE NEED TO ADD +3 TO PLAYER CHARISMA HERE
                complete = true;
                nextScene = new ShipScene(); // should be a level based on the previous choice. In this case, I only have one level, so I just return it
            }
            case EAT ->{
                System.out.println("Its old fish… you feel a sickly rumble in your stomach and your body begins to feel weak. You have food poisoning." +
                        "The sight of the moving water, Harry’s dead corpse, and what you now smell to be hot rotted fish all cause you to gag. You slip off of the side of the ship to your doom!");
              //WE NEED TO ADD A PLAYER DEAD SCENE
                complete = true;
                nextScene = new ShipScene(); // should be a level based on the previous choice. In this case, I only have one level, so I just return it
            }


            default -> System.out.println("Invalid key press");
        }

    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Scene getNextLevel() {
        return null;
    }

    @Override
    public SceneState getSceneState() {
        return _sceneState;
    }
}
