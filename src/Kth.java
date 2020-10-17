import java.util.Scanner;

public class Kth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        long step = 0; //степень десятки
        long r = 1; //количество цифр в числе
        long sum = -1; //длина строки, составленная из чисел состоящих от 1 до r цифр
        long res; //число с необходимым элементом
        long delta = 0; //приращение до числа

        while ((sum += 9 * r * Math.pow(10, step)) < k) {
            r++;
            step++;
        }

        long i = 0;
        long j = 0;
        while (i < r - 1) {
            j += 9 * Math.pow(10, i);
            delta += j;
            i++;
        }

        long place; //место элемента в числе (справа на лево)
        res = (k + delta) / r + 1;
        place = (res * r - delta) - k;

        System.out.println("Символ: " + findNumeralInNumber(res, place));
    }

    public static long findNumeralInNumber(long num, long place) {
        long i = 1;
        long t = 0;
        while (i++ <= place) {
            t = num % 10;
            num = (num - t) / 10;
        }
        return t;
    }
}