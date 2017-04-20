package io.reinert.epi.c5;

public class p2 {
    public static void main(String[] args) {
        System.out.println(swapBits(0b00, 0, 1) == 0b00);
        System.out.println(swapBits(0b01, 0, 1) == 0b10);
        System.out.println(swapBits(0b10, 0, 1) == 0b01);
        System.out.println(swapBits(0b11, 0, 1) == 0b11);

        System.out.println(swapBits(0b001, 0, 2) == 0b100);
        System.out.println(swapBits(0b1001, 1, 3) == 0b0011);
        System.out.println(swapBits(0b100110, 2, 4) == 0b110010);
    }

    public static long swapBits(long x, int i, int j) {
        // Extract the bits and check if they differ
        if ((i != j) && (((x >>> i) & 1L) != ((x >>> j) & 1L))) {
            long bitmask = (1L << i) | (1L << j);
            x ^= bitmask;
        }
        return x;
    }
}
