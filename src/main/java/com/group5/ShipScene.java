package com.group5;

public class ShipScene implements Scene {

    private SceneState _sceneState;
    private boolean complete;
    private Scene nextScene;

    public ShipScene() {
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

        _sceneState.getChoices().add("(1e)Grab the katana.");
        _sceneState.getChoices().add("(1f)Investigate the Amulet");
        _sceneState.getChoices().add("(1g)Eat fish sandwich");
    }

    @Override
    public void handleEvent(GameEvent event, Player player) {
        switch (event) {
            case GRAB -> {
                System.out.println(
                    " You grab the sword and realize it is rather small.\n" +
                        "The green handle would fit in the hand of a child and the short blade has writing you do not understand.\n" +
                        "*Player earns +3 to strength and dexterity!*\n" +
                        "You are filled with determination as you enter the shell to investigate who could have killed Harry"
                );

                player.addItem("Katana");
                complete = true;
                nextScene = new caveScene();  //player goes to cave scene
            }
            case INSPECT -> {
                System.out.println(
                    "You take the Amulet and see it glow. \n" +
                        "*Player earns +2 to performance and charisma!\n " +
                        "You’re tempted to open it but you look at the far-too-aged Harry and decide against it.\n " +
                        "You are increasingly curious about what mystical events occurred here and take your first step into the shell to find answers.\n"
                );
                player.addItem("Amulet");
                complete = true;
                nextScene = new caveScene(); //player goes to cave scene
            }
            case EAT -> {
                System.out.println(
                    "Its old fish… you feel a sickly rumble in your stomach and your body begins to feel weak.\n" +
                        " You have food poisoning.\n" +
                        "The sight of the moving water, Harry’s dead corpse, and what you now smell to be hot rotted fish all cause you to gag.\n " +
                        "You slip off of the side of the ship to your doom!\n"
                );
                player.setPlayerDead(); // player is dead, don't need to return a new scene
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
