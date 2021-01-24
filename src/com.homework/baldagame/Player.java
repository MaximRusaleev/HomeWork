package com.homework.baldagame;

import java.util.HashSet;

public class Player {
    private String name;
    private int point;
    private Boolean continues;
    private HashSet<String> wordPlayer = new HashSet<>();
    private Boolean playerInGame = true;

    public Player(String name) {
        this.name = name;
        this.point = 0;
        this.continues = true;
    }

    public void addWord(String word) {
        wordPlayer.add(word);
    }

    public void addPoint(int point) {
        this.point += point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPlayerInGame() {
        return playerInGame;
    }

    public void setPlayerInGame(Boolean playerInGame) {
        this.playerInGame = playerInGame;
    }

    @Override
    public String toString() {
        return name + '\'' +
                " счет: " + point;
    }
}
