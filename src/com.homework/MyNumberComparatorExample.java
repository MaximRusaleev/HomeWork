package com.homework;

import java.util.*;

/*
9-1: (Компаратор) Класс целых чисел с порядком на основе количества простых делителей.
*/
class MyNumber {
    private Integer value;

    public MyNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "value=" + value +
                '}';
    }
}

class MyNumberComparatorVoz implements Comparator<MyNumber> {

    @Override
    public int compare(MyNumber o1, MyNumber o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
    }
}

class MyNumberComparator implements Comparator<MyNumber> {

    private Boolean isSimpleNumber(Integer numb) {
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

    private Integer countSimpleNumber(Integer numb) {
        Integer countNum = 0;
        for (int i = 1; i <= numb; i++) {
            if (numb % i == 0 && isSimpleNumber(i)) {
                countNum++;
            }
        }
        return countNum;
    }

    @Override
    public int compare(MyNumber t, MyNumber t1) {
        return Integer.compare(countSimpleNumber(t.getValue()), countSimpleNumber(t1.getValue()));
    }
}

public class MyNumberComparatorExample {
    public static void main(String[] args) {
        Comparator<MyNumber> compNumb = new MyNumberComparator().thenComparing(new MyNumberComparatorVoz());
        ArrayList<MyNumber> treeNumber = new ArrayList<MyNumber>();
        treeNumber.add(new MyNumber(10));
        treeNumber.add(new MyNumber(1));
        treeNumber.add(new MyNumber(23));
        treeNumber.add(new MyNumber(105));
        treeNumber.add(new MyNumber(3));
        Collections.sort(treeNumber, compNumb);

        for (MyNumber myNumber : treeNumber) {
            System.out.println(myNumber);
        }
    }

}