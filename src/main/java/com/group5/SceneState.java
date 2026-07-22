package com.group5;

import java.util.ArrayList;


public class SceneState {
    private final String title = "CAPTAIN'S COVE ";
    private String sceneName;
    private String _story;
    private ArrayList<String> _choices;
    private boolean hasEnemy;
    private  String enemyName;
    private  String ability;

    public SceneState(){

        _choices = new ArrayList<String>();
        hasEnemy = false;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getTitle() {
        return title;
    }

    public String getStory() {
        return _story;
    }

    public void setStory(String _story) {
        this._story = _story;
    }

    public ArrayList<String> getChoices() {
        return _choices;
    }
    public boolean isSceneEnemy(){
        return  hasEnemy;
    }
    public  void setSceneIsEnemy(){
        hasEnemy =true;
    }
    public void setEnemyNameAndAbility(String name, String _ability){
        enemyName = name;
        ability = _ability;
    }
    public String getEnemyName() {
        return enemyName;
    }
    public String getAbility(){
        return ability;
    }
}
