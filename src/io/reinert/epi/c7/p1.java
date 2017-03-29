package io.reinert.epi.c7;

public class p1 {

    public static void main(String[] args) {
        System.out.println(stringToInt("-123"));
        System.out.println(intToString(-123));
    }

    public static String intToString(int n) {
        StringBuilder sb = new StringBuilder();
        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }
        do {
            sb.append(n % 10);
            n /= 10;
        } while (n > 0);
        if (neg) sb.append('-');
        return sb.reverse().toString();
    }

    public static int stringToInt(String s) {
        int n = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
            final int d = s.charAt(i) - '0'; //implicit conversion char to int
            n = n * 10 + d;
        }
        return s.charAt(0) == '-' ? -n : n;
    }


    public static int myStringToInt(String s) {
        int n = 0;

        int m = 1;
        int l = 0;
        if (s.charAt(0) == '-') {
            m = -1;
            l = 1;
        }

        for (int k = s.length() - 1; k >= l; --k) {
            n += (getInt(s.charAt(k)) * 10^(k-1));
        }

        n *= m;

        return n;
    }

    static int getInt(char c) {
        return ((int)c) - 48;
    }
}
