package com.homework;

/* Написать функцию, которая убирает одинаковые значения из списка */

import java.util.ArrayList;

public class ListWithoutDouble {

    public static ArrayList<Integer> delDouble(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) == arr.get(j)) {
                    arr.remove(j--);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList = delDouble(arrayList);
        for (int i : arrayList) {
            System.out.print(i + " ");
        }
    }
}
