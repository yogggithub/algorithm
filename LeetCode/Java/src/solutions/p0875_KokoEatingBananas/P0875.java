package solutions.p0875_KokoEatingBananas;

import java.util.Arrays;

public class P0875 {
    public int minEatingSpeed(int[] piles, int h) {
        /*
         * Solution v1: Binary Search
         *
         * Java built-in Math.ceil seem result different
         *
         * Runtime: 20 ms @ (beats) 68.34%
         * Memory Usage: 43.2 MB @ (beats) 69.24%
         */

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int mid = (l + r) / 2;

            int hours = 0;
            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid != 0) {
                    hours++;
                }
            }

            if (hours > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;

    }
}
