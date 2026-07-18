package com.group5;


public class CrabScene implements Scene {

    private SceneState _sceneState;
    private boolean complete;
    private Scene nextScene;

    public CrabScene() {
        this._sceneState = new SceneState();
        _sceneState.setSceneName("Ship scene");
        _sceneState.setStory(
            """
                CRAB prompt, not sure what to put
            """
        );

        _sceneState.getChoices().add("(1e) Fight crab");
        _sceneState.getChoices().add("(1f) use loot");
    }

    @Override
    public void handleEvent(GameEvent event, Player player) {
        switch (event) {
            case FIGHT -> {

            }
            case USE_LOOT -> {
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
