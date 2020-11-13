package com.homework;

/* Рисование рамки вокруг текстовой строки*/

import java.util.Scanner;

public class Frame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vertical = in.nextInt();
        int horizontal = in.nextInt();
        String str = in.next();
        int strLength = str.length();
        if (vertical > 2 && strLength < horizontal - 1) {
            int centrD = (vertical - 1) / 2; //центр по вертикали
            int centrS = (horizontal - strLength) / 2; // центр по горизонтали
            for (int i = 0; i < vertical; i++) {
                for (int j = 0; j < horizontal; j++) {
                    if ((i == 0) || (i == vertical - 1) || (j == 0) || (j == horizontal - 1)) {
                        System.out.print("*");
                    } else if (i == centrD && j == centrS) {
                        System.out.print(str);
                        j += strLength - 1;
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        } else {
            System.out.println("Ошибка");
        }
    }
}