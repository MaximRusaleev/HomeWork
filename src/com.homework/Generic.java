package com.homework;

import java.util.ArrayList;

/*
9-2: (Generics) Напишите общий метод для подсчета количества элементов в коллекции, которые имеют определенное свойство
(например, нечетные целые числа, простые числа, палиндромы). Данное свойство реализовать через функциональный интерфейс,
который возвращает true/false в зависимости от принадлежности к свойству или нет
*/

@FunctionalInterface
interface SimpleCheckFunction<T extends Integer> {
    boolean simpleCheck(T a);
}

public class Generic {

    private static Boolean isSimpleNumber(Integer numb) {
        Integer countNum = 0;
        if (numb == 1) {
            return true;
        }
        for (int i = 1; i <= numb; i++) {
            if (numb % i == 0) {
                countNum++;
            }
        }
        if (countNum == 2) {
            return true;
        }
        return false;
    }

    public static int countSimpleNum(ArrayList<Integer> arrayList) {
        int count = 0;

        SimpleCheckFunction simpleCheckFunction = (a -> isSimpleNumber(a));

        for (Integer value : arrayList) {
            if (simpleCheckFunction.simpleCheck(value)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(105);
        arrayList.add(7);
        arrayList.add(11);
        arrayList.add(23);

        System.out.println(countSimpleNum(arrayList));
    }
}