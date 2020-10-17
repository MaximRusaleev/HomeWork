import java.util.Scanner;

public class CodeFibonachi {

    public static int fibonachi(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
    }

    public static String codeFibonachi(long num) {
        long maxNum = 0;
        long i = 1;
        long numFib = fibonachi(i);
        if (num > numFib) {
            while (num >= (numFib = fibonachi(i++))) {
                maxNum = numFib;
            }
        } else {
            maxNum = numFib;
        }
        String ii;
        i -= 3;
        ii = String.valueOf((long)Math.pow(10, i));
        long razn = num - maxNum;
        if (razn > 0) {
            System.out.println("1: " + maxNum);
            ii += codeFibonachi(razn);
        } else {
            System.out.println("2: " + maxNum);
            return ii;
        }

        return ii;
    }

    public static void main(String[] arg) {
        System.out.println(codeFibonachi(100));
    }
}
