package com.group5;

public class Dice{
    public int rollDice(){
        return (int) (Math.random() * 20);
    }
    public int rollCrabDice(){
        return (int) (Math.random() * 45);
    }
}
