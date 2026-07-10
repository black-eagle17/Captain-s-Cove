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
            "  The deeper and deeper you go, the darker and darker it gets." +
                " Your feet are wary and your spirits are low. You slowly come upon lights." +
                " A fire of some sort? No… magic? There are 3 tunnels, all glowing with a different color light." +
                "on the left you smell the scent of fish down Blue tunnel, in the center you hear music down Purple tunnel, and to the right see shadows moving down Green tunnel "
        );
        _sceneState.getChoices().add("(L)Blue Cave.");
        _sceneState.getChoices().add("(C)Purple Cave.");
        _sceneState.getChoices().add("(R)Green Cave.");
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
                _sceneState.getChoices().add("(A)ttack");
                _sceneState.getChoices().add("(S)ing");
                _sceneState.getChoices().add("(F)lee");
            }
            case RIGHT -> {
                System.out.println(
                    "Goblins!\n " +
                        "*Dice Roll Encounter\n" +
                        "You run down the green tunnel towards the shadows.\n " +
                        "Could it be your friends? Could it be their captors?\n" +
                        "You stop in your tracks to see a giant door.Guarding it, goblins. Like, a bunch of Goblins.\n" +
                        "The Goblins hiss at you before falling into formation, their swords pointed towards you.\n" +
                        "You’ve only got one turn at this, choose an action: Swing Sword, Explain yourself, Flee\n"
                );
                complete = true;
                nextScene = new ShipScene(); // TODO: A NEW SCENE WILL BE ADDED HERE FROM SCRIPT THAT INCLUDES A PLAYER DICE ROLL AND GOBLIN ENCOUNTER
            }
            case ATTACK -> {
                itemCheck.evaluateInventory(player);
            }
            case SING -> {
                System.out.println("You have chosen to sinnnnggggg....");
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
