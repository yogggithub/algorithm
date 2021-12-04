package solutions.p0441_ArrangingCoins;

public class P0441 {
    public int arrangeCoins(int n) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 9 ms @ (beats) 21.86%
         * Memory Usage: 36.3 MB @ (beats) 52.22%
         */
        // int reminder = n;
        // for (int i = 1; i < n; i++) {
        //     if (reminder < i) {
        //         return i - 1;
        //     } else if (reminder == i) {
        //         return i;
        //     } else {
        //         reminder -= i;
        //     }
        // }
        // return 1;

        /*
         * Solution v2: Math
         *
         * Runtime: ms @ (beats) 21.86%
         * Memory Usage: MB @ (beats) 52.22%
         */
        // Formula for finding the roots of quadratic equation of one unknown
        // n = (1 + x) * x / 2 -> x^2 + x -2n = 0
        // x = (-1 + sqrt(1+8n))/2
        // Just round down to the nearest whole number
        return (int) (-1 + Math.sqrt(1 + 8 * n)) / 2;
    }
}
