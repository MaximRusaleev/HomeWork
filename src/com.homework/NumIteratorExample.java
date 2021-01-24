package com.homework;

import java.util.Iterator;

/*
8: (Итератор) последовательность целых чисел с итератором по цифрам десятичного представления чисел (в обратном направлении)
Дополнительно: в прямом направлении.
*/
class Numb implements Iterable<Integer> {
    private Integer num;

    public Numb(Integer num) {
        this.num = num;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NumberIterator();
    }

    class NumberIterator implements Iterator<Integer> {
        private int pos;

        // Обратное направление
        private Integer numPos() {
            Integer number = num;
            Integer currentPos = 0;
            Integer numeral = 0;
            while (currentPos++ <= pos) {
                numeral = number % 10;
                number = (number - numeral) / 10;
            }
            return numeral;
        }

        // Прямое направление
        /*private Integer numPos() {
            Integer number = num;
            Integer currentPos = 0;
            Integer numeral = 0;
            Integer length = 0;
            while (Math.pow(10, length) <= number) {
                length++;
            }
            while (currentPos++ <= pos) {
                length--;
                numeral = (int) (number / Math.pow(10, length));
                number = (int) (number % Math.pow(10, length));
            }
            return numeral;
        }*/

        @Override
        public boolean hasNext() {
            if (Math.pow(10, pos) <= num || (num == 0 && pos == 0)) {
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            Integer value = 0;
            value = numPos();
            pos++;
            return value;
        }
    }
}

public class NumIteratorExample {
    public static void main(String[] args) {
        Numb numb = new Numb(261561);
        for (Integer num : numb) {
            System.out.println(num);
        }
    }
}