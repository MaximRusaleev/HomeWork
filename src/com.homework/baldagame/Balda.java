package com.homework.baldagame;

import java.util.Scanner;

public class Balda {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countPlayer;
        String state;
        String word;
        System.out.println("Введите количество игроков");
        countPlayer = Integer.parseInt(in.nextLine());
        System.out.println("Введите слово");
        word = in.nextLine();
        GameRule gameRule = new GameRule(word, countPlayer);
        Player currentPlayer = gameRule.currentPlayer();

        do {
            System.out.println(currentPlayer.getName() + " введите ваш вариант");
            word = in.nextLine();
            state = gameRule.addVersionWordPlayer(word, currentPlayer);
            if (state.equals("+")) {
                currentPlayer = gameRule.nextPlayer();
            } else {
                System.out.println(state);
            }
        } while (gameRule.gameMove());

        for (Player player : gameRule.getLinkedPlayerResult()) {
            System.out.println(player.toString());
        }
    }
}
