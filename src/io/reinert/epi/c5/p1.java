package io.reinert.epi.c5;

public class p1 {

    static int WORD_SIZE = 16;
    static int BIT_MASK = 0xFFFF;
    static byte[] PARITY_LOOKUP_TABLE = new byte[BIT_MASK + 1];

    public static void main(String[] args) {
        for (int x = 0; x < PARITY_LOOKUP_TABLE.length; ++x) {
            PARITY_LOOKUP_TABLE[x] = parityScalar(x);
        }

        System.out.println(parityLinear(0) == 0);
        System.out.println(parityLinear(1) == 1);
        System.out.println(parityLinear(2) == 1);
        System.out.println(parityLinear(3) == 0);
        System.out.println(parityLinear(1023) == 0);

        System.out.println(parityScalar(0) == 0);
        System.out.println(parityScalar(1) == 1);
        System.out.println(parityScalar(2) == 1);
        System.out.println(parityScalar(3) == 0);
        System.out.println(parityScalar(1023) == 0);

        System.out.println(parityLookup(0) == 0);
        System.out.println(parityLookup(1) == 1);
        System.out.println(parityLookup(2) == 1);
        System.out.println(parityLookup(3) == 0);
        System.out.println(parityLookup(1023) == 0);

        System.out.println(parityLogarithmic(0) == 0);
        System.out.println(parityLogarithmic(1) == 1);
        System.out.println(parityLogarithmic(2) == 1);
        System.out.println(parityLogarithmic(3) == 0);
        System.out.println(parityLogarithmic(1023) == 0);
    }

    // O(n) where n is the number o bits
    private static byte parityLinear(int n) {
        byte parity = 0;

        while (n != 0) {
            parity ^= (n & 1);
            n >>>= 1;
        }

        return parity;
    }

    // O(k) where k is the number of bits set to 1
    private static byte parityScalar(int n) {
        byte parity = 0;

        while (n != 0) {
            parity ^= 1;
            n &= (n - 1); // "replaces the lowest bit that is 1 with 0" (p.26)
        }

        return parity;
    }

    // O(n/L) where L is the size of the precomputed words
    private static byte parityLookup(long n) {
        return (byte) (PARITY_LOOKUP_TABLE[(int)((n >>> (3 * WORD_SIZE)) & BIT_MASK)]
                        ^ PARITY_LOOKUP_TABLE[(int)((n >>> (2 * WORD_SIZE)) & BIT_MASK)]
                        ^ PARITY_LOOKUP_TABLE[(int)((n >>> WORD_SIZE) & BIT_MASK)]
                        ^ PARITY_LOOKUP_TABLE[(int)(n & BIT_MASK)]);
    }

    // O(log n)
    private static byte parityLogarithmic(long n) {
        n ^= n >>> 32;
        n ^= n >>> 16;
        n ^= n >>> 8;
        n ^= n >>> 4;
        n ^= n >>> 2;
        n ^= n >>> 1;
        return (byte)(n & 0b1);
    }
}
