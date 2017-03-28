package io.reinert.epi.c6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p1 {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(0, 1, 2, 0, 1, 2, 1, 0);
        int pivotIdx = 1;
        System.out.println(dutchFlagPartition(pivotIdx, A));
    }

    public static List<Integer> dutchFlagPartition(int pivotIdx, List<Integer> A) {
        Integer pivot = A.get(pivotIdx);
        int s = 0;
        int u = 0;
        int l = A.size() - 1;

        while (u < l) {
            if (A.get(u) > pivot) {
                Collections.swap(A, u, l--);
            } else if (A.get(u) < pivot) {
                Collections.swap(A, u++, s++);
            } else {
                u++;
            }
        }

        return A;
    }
}
