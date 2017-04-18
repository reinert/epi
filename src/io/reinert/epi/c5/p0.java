package io.reinert.epi.c5;

public class p0 {
    public static void main(String[] args) {
        System.out.println(countBits(1) == 1);
        System.out.println(countBits(2) == 1);
        System.out.println(countBits(3) == 2);
        System.out.println(countBits(4) == 1);
        System.out.println(countBits(5) == 2);
        System.out.println(countBits(6) == 2);
        System.out.println(countBits(7) == 3);
        System.out.println(countBits(1023) == 10);
    }

    public static short countBits(int x) {
        short numBits = 0;
        while (x != 0) {
            numBits += (x & 1); // mask
            x >>>= 1; // shift
        }
        return numBits;
    }
}
