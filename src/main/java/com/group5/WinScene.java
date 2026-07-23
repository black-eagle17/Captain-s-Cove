package com.group5;


public class WinScene implements Scene{
    private SceneState _sceneState;
    private boolean complete;
    private  Scene nextScene;

    public WinScene(){
        this._sceneState = new SceneState();
        _sceneState.setSceneName("Winner");
        _sceneState.setStory(
                """
                WINNER!
                WINNER!
                WINNER!
                WINNER!
                WINNER!
                WINNER!
                        """
        );
        _sceneState.getChoices().add("(6a) View player stats ");
        _sceneState.getChoices().add("(q) Exit ");
    }

    @Override
    public void handleEvent(GameEvent event, Player player, Enemy _enemy) {
        switch (event){
            case STATS ->{
                _sceneState.setStory("We should output player stats we have tracked\n");
                complete = false;
                nextScene = null;// game over
            }
            case QUIT ->{

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
