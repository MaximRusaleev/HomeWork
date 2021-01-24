package com.homework;

/* Написать функцию, которая переворачивает массив, размерностью 8*/

public class ArrayTurn {

    public static int[] arrayTurn(int[] arr) {
        int len = arr.length;
        int interValue;
        for (int i = 0; i < len / 2; i++) {
            interValue = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = interValue;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {8, 7, 6, 5, 4, 3, 2, 1};
        for (int j : arrayTurn(array)) {
            System.out.print(j + " ");
        }
    }
}

