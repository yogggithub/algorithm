package problems.p0441_ArrangingCoins;

/*
 * You have n coins and you want to build a staircase with these coins.
 * The staircase consists of k rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 * Example 1:
 * 1
 * 1    1
 * 1    1   null
 *
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 * 1
 * 1    1
 * 1    1   1
 * 1    1   null    null
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *
 * Constraints:
 * 1 <= n <= 231 - 1
 */
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
