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
                        The cold salt water hitting your face is what wakes you first, the crab pinching your foot is what gets you to jolt up to your feet!
                        Your heart pounds in your chest as you frantically look around you, finding yourself on the shore of an unfamiliar beach. As the salt
                        water hits the scars in your legs, you begin to remember. Your ship, it crashed! You look to your right and there it is, just a couple yards out,
                        “The Artemis!”  Your prized vessel slammed up against a rock with what looks to be a… giant shell atop it? Hunger pangs in your stomach and you
                        remember again that you haven’t eaten in days. Time is of the essence, use it wisely.
                        
                        """
        );
        _sceneState.getChoices().add("(T)ravel inland and search for food.");
        _sceneState.getChoices().add("(I)nvestigate the Artemis <!>");
    }

    @Override
    public void handleEvent(GameEvent event, Player player) {
        switch (event){
            case TRAVEL ->{
                System.out.println("You have chosen to travel");
                complete = true;
                nextScene = new IntroScene();// should be a level based on the previous choice. In this case, I only have one level, so I just return it
            }
            case INVESTIGATE ->{
                System.out.println("You have chosen to investigate the ship");
                complete = true;
                nextScene = new IntroScene(); // should be a level based on the previous choice. In this case, I only have one level, so I just return it
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
