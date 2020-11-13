package com.homework.baldagame;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GameRule {

    private final String word;
    private Set<Character> charInWord;
    private Set<String> inputWord = new HashSet<>();
    private LinkedList<Player> linkedPlayer = new LinkedList<>();
    private LinkedList<Player> linkedPlayerResult;

    public GameRule(String word, int countPlayer) {
        this.word = word;
        charInWord = WorkWithWord.getChars(word);
        for (int i = 0; i < countPlayer; i++) {
            linkedPlayer.add(i, new Player("Игрок №" + i));
        }
        linkedPlayerResult = (LinkedList<Player>) linkedPlayer.clone();
    }

    public String addVersionWordPlayer(String wordPlayer, Player player) {
        if (wordPlayer.isBlank()) {
            player.setPlayerInGame(false);
        } else {
            if (!WorkWithWord.isContainsAll(charInWord, WorkWithWord.getChars(wordPlayer))) {
                return "Введеное слово не состоит из букв изначального слова";
            } else if (inputWord.contains(wordPlayer)) {
                return "Такое слово уже было введено";
            } else {
                inputWord.add(wordPlayer);
                player.addWord(wordPlayer);
                player.addPoint(WorkWithWord.countPoints(wordPlayer));
            }
        }
        return "+";
    }

    public Player currentPlayer() {
        return linkedPlayer.getFirst();
    }

    public Player nextPlayer() {
        linkedPlayer.addLast(linkedPlayer.getFirst());
        linkedPlayer.removeFirst();
        return linkedPlayer.getFirst();
    }

    public Boolean gameMove() {
        Boolean checkPlayerInGame = false;
        for (int i = 0; i < linkedPlayer.size(); i++) {
            if (linkedPlayer.get(i).getPlayerInGame()) {
                checkPlayerInGame = true;
            } else {
                linkedPlayer.remove(i);
            }
        }
        return checkPlayerInGame;
    }

    public LinkedList<Player> getLinkedPlayerResult() {
        return linkedPlayerResult;
    }
}
