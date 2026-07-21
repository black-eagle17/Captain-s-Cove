package com.group5;

import java.util.ArrayList;


public class SceneState {
    private final String title = "CAPTAIN'S COVE ";
    private String sceneName;
    private String _story;
    private Enemy _enemy;
    private ArrayList<String> _choices;

    public SceneState(){
        _choices = new ArrayList<String>();
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

    public String getEnemy() {
        return _enemy;
    }

    public void setEnemy(String _enemy) {
        this._enemy = _enemy;
    }

    public ArrayList<String> getChoices() {
        return _choices;
    }
}
