package com.homework;

/* Написать функцию, которая проверяет, является ли слово палиндромом */

public class Recursion {

    public static boolean recursion(String str) {
        int strLength = str.length();
        if (strLength == 1) {
            return true;
        } else if (strLength > 1 && str.charAt(0) == str.charAt(strLength - 1)) {
            return rec1(str.substring(1, strLength - 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String word = "топот";
        System.out.println(recursion(word));
    }
}
