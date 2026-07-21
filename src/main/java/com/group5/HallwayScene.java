package com.group5;

public class HallwayScene implements Scene{
    private SceneState _sceneState;
    private boolean complete;
    private Scene nextScene;
   private LootBox goldenChest;

    public HallwayScene(){
        this._sceneState = new SceneState();
        this.goldenChest = new LootBox();
        _sceneState.setSceneName("Hallway Scene");
        _sceneState.setStory(

                        "As you continue to walk you find yourself in a narrow stone tunnel dimly lit by the occasional torch.\n"+
                          "With nowhere else to go, you tread forward desperately trying to remain calm.\n"+
                            "The tunnel appears to be coming to an end. You see an opening, and you walk into a large room with a humongous wooden door engraved with unfamiliar markings.\n"+
                            "From behind the door, you hear voices like that of your crew mates accompanied by a fast scuttering from what could only be “the beast”.\n"+
                             "Before entering, you encounter a chest that is radiating with a golden white light.\n"+
                                "You take another step towards the door, and *WHOOSH* the chest opens, you are suddenly hit in the face with party confetti?\n"+
                                "A floating orb of light rises from the chest, and it begins to cycle between three objects a helmet, pair of boots, and a vial of glowing blue liquid.\n"
        );
        _sceneState.getChoices().add("(ll)Grab loot");

    }

    @Override
    public void handleEvent(GameEvent event, Player player, Enemy _enemy) {
        String lootItem =  goldenChest.determineLoot(goldenChest.diceRoll());
        player.addItem(lootItem);
        System.out.println("You have aquired: " + lootItem);
        System.out.println(" ");

        complete = true;
        nextScene = new FinalBossIntroScene();
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
