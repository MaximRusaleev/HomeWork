/* Рисование рамки вокруг текстовой строки*/

import java.util.Scanner;

public class Frame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        int s = in.nextInt();
        String str = in.next();
        int strLength = str.length();
        if (d > 2 && strLength < s - 1) {
            int centrD = (d - 1) / 2; //центр по вертикали
            int centrS = (s - strLength) / 2; // центр по горизонтали
            for (int i = 0; i < d; i++) {
                for (int j = 0; j < s; j++) {
                    if ((i == 0) || (i == d - 1) || (j == 0) || (j == s - 1)) {
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