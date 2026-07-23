package com.group5;

public class ShipScene implements Scene {
    private SceneState _sceneState;
    private boolean complete;
    private Scene nextScene;

    public ShipScene() {
        this._sceneState = new SceneState();
        _sceneState.setSceneName("Ship scene");
        _sceneState.setStory(
                "“What happened to my crew?”\n\n" +
                        "You use all your might to swim to *The Artemis*, your prized fishing vessel.\n" +
                        "You make your way onto the boat and find a skeleton! By God, how long has it been?\n\n" +
                        "You check the body and see its clothes match one of your crewmates, Harry.\n" +
                        "The poor bastard. He has a small sword in his chest.\n" +
                        "In his hand, a strange Amulet. And next to him… a tuna sandwich-\n" +
                        "fresher than Harry for sure but questionable."
        );
        _sceneState.getChoices().add("[1e] Grab the katana.");
        _sceneState.getChoices().add("[1f] Investigate the Amulet");
        _sceneState.getChoices().add("[1g] Eat fish sandwich");
    }

    @Override
    public void handleEvent(GameEvent event, Player player, Enemy _enemy) {
        System.out.println("\n--------------------------------------------------"); // Clear separator for actions

        switch (event) {
            case GRAB -> {
                System.out.println(
                        " You grab the sword and realize it is rather small.\n" +
                                " The green handle would fit in the hand of a child and the short blade \n" +
                                " has writing you do not understand.\n\n" +
                                " >> EFFECT: Player earns +3 to strength and dexterity! <<\n\n" +
                                " You are filled with determination as you enter the shell to investigate \n" +
                                " who could have killed Harry."
                );
                player.addItem("Katana");
                complete = true;
                nextScene = new caveScene();
            }
            case INSPECT -> {
                System.out.println(
                        " You take the Amulet and see it glow.\n\n" +
                                " >> EFFECT: Player earns +2 to performance and charisma! <<\n\n" +
                                " You’re tempted to open it but you look at the far-too-aged Harry \n" +
                                " and decide against it.\n\n" +
                                " You are increasingly curious about what mystical events occurred here \n" +
                                " and take your first step into the shell to find answers."
                );
                player.addItem("Amulet");
                complete = true;
                nextScene = new caveScene();
            }
            case EAT -> {
                System.out.println(
                        " Its old fish… you feel a sickly rumble in your stomach and your body \n" +
                                " begins to feel weak.\n\n" +
                                " !! ALERT: You have food poisoning. !!\n\n" +
                                " The sight of the moving water, Harry’s dead corpse, and what you now \n" +
                                " smell to be hot rotted fish all cause you to gag.\n\n" +
                                " GAME OVER: You slip off of the side of the ship to your doom!"
                );
                player.setPlayerDead();
            }
            default -> System.out.println(" [!] Invalid key press. Try again.");
        }
        System.out.println("--------------------------------------------------\n");
    }

    @Override
    public boolean isComplete() { return complete; }

    @Override
    public Scene getNextLevel() { return nextScene; }

    @Override
    public SceneState getSceneState() { return _sceneState; }
}