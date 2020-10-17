public class Recursion {
    public static boolean rec(String str, int n) {
        int l = str.length();
        if ((n < l / 2) && (str.charAt(n) == str.charAt(l - n - 1)) && (l > 1)) {
            return rec(str, n + 1);
        } else if (n >= l / 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean rec1(String str) {
        int l = str.length();
        if (l == 1) {
            return true;
        } else if (l > 1 && str.charAt(0) == str.charAt(l - 1)) {
            return rec1(str.substring(1, l - 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "топот";
        System.out.println(rec(s, 0));
        System.out.println(rec1(s));
    }
}
