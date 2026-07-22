package com.group5;


public class IntroScene implements Scene{
    private SceneState _sceneState;
    private boolean complete;
    private  Scene nextScene;

    public IntroScene(){
        this._sceneState = new SceneState();
        _sceneState.setSceneName("Intro Scene");
        _sceneState.setStory(
                """
                        The cold salt water hitting your face is what wakes you first,
                         the crab pinching your foot is what gets you to jolt up to your feet!
                        Your heart pounds in your chest as you frantically look around you,
                        finding yourself on the shore of an unfamiliar beach. As the salt
                        water hits the scars in your legs, you begin to remember. Your ship, it crashed!
                        You look to your right and there it is, just a couple yards out,
                        “The Artemis!”  Your prized vessel slammed up against a rock with what looks to be a… giant shell atop it?
                        Hunger pangs in your stomach and you
                        remember again that you haven’t eaten in days.
                        Time is of the essence, use it wisely.

                        """
        );
        _sceneState.getChoices().add("(1a) Travel inland and search for food.");
        _sceneState.getChoices().add("(1b) Investigate the Artemis!!");
    }

    @Override
    public void handleEvent(GameEvent event, Player player, Enemy _enemy) {
        switch (event){
            case TRAVEL ->{
                System.out.println("You have chosen to travel\n");
                complete = true;
                nextScene = new InlandScene();// player goes inland
            }
            case INVESTIGATE ->{
                System.out.println("You have chosen to investigate the ship\n");
                complete = true;
                nextScene = new ShipScene(); // player goes to the ship
            }
            default -> System.out.println("Invalid key press\n");
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
