package com.homework;

/* Вычисление k-го символа строки из натуральных чисел*/

import java.util.Scanner;

public class Kth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long numeralInNumber = in.nextLong();
        long step = 0; //степень десятки
        long lengthNumber = 1; //количество цифр в числе
        long sum = -1; //длина строки, составленная из чисел состоящих от 1 до lengthNumber цифр
        long res; //число с необходимым элементом
        long delta = 0; //приращение до числа

        while ((sum += 9 * lengthNumber * Math.pow(10, step)) < numeralInNumber) {
            lengthNumber++;
            step++;
        }

        long i = 0;
        long j = 0;
        while (i < lengthNumber - 1) {
            j += 9 * Math.pow(10, i);
            delta += j;
            i++;
        }

        long place; //место элемента в числе (справа на лево)
        res = (numeralInNumber + delta) / lengthNumber + 1;
        place = (res * lengthNumber - delta) - numeralInNumber;

        System.out.println("Символ: " + findNumeralInNumber(res, place));
    }

    public static long findNumeralInNumber(long number, long place) {
        long i = 1;
        long numeral = 0;
        while (i++ <= place) {
            numeral = number % 10;
            number = (number - numeral) / 10;
        }
        return numeral;
    }
}