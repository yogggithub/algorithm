package solutions.p0605_CanPlaceFlowers;

public class P0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 100%
         * Memory Usage: 44.2 MB @ (beats) 22.58%
         */

        if (n == 0) {
            return true;
        }

        int count  = 1;

        for (int i = 0; i <= flowerbed.length; i++) {
            int curr;
            if (i == flowerbed.length) {
                curr = 0;
            } else {
                curr = flowerbed[i];
            }

            if (curr == 0) {
                if (++count == 3) {
                    n--;
                    if (n == 0) {
                        return true;
                    }
                    count = 1;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }
}
