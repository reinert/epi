package io.reinert.epi.c5;

import java.util.Arrays;

public class p3 {

    static final int WORD_SIZE = 2;
    static final int BIT_MASK = 0b11;
    static final int[] LOOKUP_TABLE = new int[BIT_MASK + 1];

    public static void main(String[] args) {
        for (int i = 0; i < LOOKUP_TABLE.length; ++i) {
            LOOKUP_TABLE[i] = (int) reverse(i);
        }

        System.out.println(Arrays.equals(LOOKUP_TABLE, new int[] {0b00, 0b10, 0b01, 0b11}));

        System.out.println(reverseLookup(0b10010011) == 0b11001001);
    }

    private static long reverseLookup(long x) {
        return LOOKUP_TABLE[((int) (x & BIT_MASK))] << (3 * WORD_SIZE)
                | LOOKUP_TABLE[((int) ((x >>> WORD_SIZE) & BIT_MASK))] << (2 * WORD_SIZE)
                | LOOKUP_TABLE[((int) ((x >>> 2 * WORD_SIZE) & BIT_MASK))] << WORD_SIZE
                | LOOKUP_TABLE[((int) ((x >>> 3 * WORD_SIZE) & BIT_MASK))];
    }

    public static long reverse(long x) {
        for (int i = 0; i < WORD_SIZE / 2; ++i) {
            x = swapBits(x, i, WORD_SIZE - 1 - i);
        }
        return x;
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
