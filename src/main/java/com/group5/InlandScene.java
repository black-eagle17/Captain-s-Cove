package com.group5;

public class InlandScene implements Scene{

    private SceneState _sceneState;
    private boolean complete;
    private  Scene nextScene;

    public InlandScene(){
        this._sceneState = new SceneState();
        _sceneState.setSceneName("Inland Scene");
        _sceneState.setStory(
                "I’ve gotta find something to eat\n" +
                        " You make your way further up the beach.\n" +
                        " As the heat of the sun on the sand begins to burn your salt-soaked feet, \n" +
                        " you hurriedly run to the closet form of shade- a small dark cave just along the water.\n" +
                        " At the edge of the cave, you spot a large, meaty, would-be-sooo delicious crab.\n" +
                        " Your stomach begins to rumble again… and just before you can move, the crab runs deeper into the darkness of the cave. \n" +
                        " You look back out to the beach and wonder when help will arrive. \n" +
                        " You look to the cave, and think how deep could it possibly go\n"+
                        "What will you decide to do?\n");

        _sceneState.getChoices().add("(S)Stay on the beach.");
        _sceneState.getChoices().add("(K)Track down the juicy crab that entered the cave");
    }

    @Override
    public void handleEvent(GameEvent event, Player player) {
        switch (event){
            case STAY ->{
                System.out.println("\n" +
                        "Waiting. Waiting. Waiting... \n" +
                        "You die :(\n ");

                //WE NEED TO ADD A PLAYER DEAD SCENE
                player.setPlayerDead(); // player is dead, don't need to return a new scene
            }
            case TRACK->{
                System.out.println("You run down the cave, listening to the sounds of the crab scuttling along,\n" +
                        " the shuffles getting fainter and fainter… \n");
                complete = true;
                nextScene = new caveScene();  }

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
