package com.group5;

public class Application {

    private final InputHandler inputHandler; //this will be responsible for grabbing input from the user and converting it into a specific type of event/
    private Scene currScene;
    private GameState _state;
    private Player player;
    private Drawer _drawer;

    //ctor
    public Application(Scene start_scene) {
        this.currScene = start_scene;
        this.inputHandler = new InputHandler();
        this._state = GameState.RUNNING;
        this.player = new Player();
        this._drawer = new Drawer();
    }

    //main game loop that advances level and handle user input
    public void run() {

        //actual game loop
        while (_state == GameState.RUNNING) {
            _drawer.draw(currScene.getSceneState(),player); // this method is responsible for drawing our UI, it takes the current scene [Scene State] and Player obj. (basically, what are the stats looking like after each action);

            GameEvent event = inputHandler.readEvent(); //grab input from the keyboard and decode which key was pressed and then turn it into an event

            //quit the game if QUIT event is detected by setting running to false
            if (event == GameEvent.QUIT) {
                _state = GameState.QUIT;
                continue;
            }

            //dispatch event to current level if we did not quit the game
            currScene.handleEvent(event, player);

            //check that we met the criteria for completing the scene or player died
            if(player.isPlayerDead()){
                _state = GameState.DIED;
            }else if (currScene.isComplete()) {
                advanceLevel(); //can I advance to the next level
            }

        }
        System.out.println("GAME OVER!!! YOU LOST"); // print game over
    }
    //grab the next scene or check if we won the game
    private void advanceLevel() {
        Scene next = currScene.getNextLevel();
        if (next == null) {
            _state = GameState.WON; //if you can't advance to the next level, and player is not dead that means you won the game!
        } else {
            currScene = next ; //set the next level/scene
        }
    }

}
