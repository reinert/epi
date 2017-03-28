package io.reinert.epi.c6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p6 {

    public static void main(String[] args) {
        System.out.println(computeMaxProfit(Arrays.asList(310,315, 275, 295, 260, 270, 290, 230, 255, 250)));
        System.out.println(bestTrade(Arrays.asList(310,315, 275, 295, 260, 270, 290, 230, 255, 250)));
    }

    // Time: O(n); Space: O(1)
    public static Integer computeMaxProfit(List<Integer> prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (Integer p : prices) {
            maxProfit = Math.max(maxProfit, p - min);
            min = Math.min(min, p);
        }

        return maxProfit;
    }

    // Time: O(n²); Space: O(n)
    public static Integer bestTrade(List<Integer> prices) {
        List<Integer> spreads = Arrays.asList(new Integer[prices.size() - 1]);

        for (int i = 0; i < prices.size(); ++i) {
            for (int k = prices.size() - 1; k > i; --k) {
                if (spreads.get(i) == null || spread(prices, i, k) > spreads.get(i)) {
                    spreads.set(i, spread(prices, i, k));
                }
            }
        }

        return Collections.max(spreads);
    }

    private static Integer spread(List<Integer> prices, int i, int k) {
        return prices.get(k) - prices.get(i);
    }
}
