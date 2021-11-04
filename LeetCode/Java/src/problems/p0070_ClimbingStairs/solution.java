package problems.p0070_ClimbingStairs;

public class solution {
    public static void main(String[] args) {
        solution self = new solution();

        // System.out.println(self.climbStairs(2));
        // System.out.println(self.climbStairs(3));
        System.out.println(self.climbStairs(4));
    }


    public int climbStairs(int n) {

        /* 不同思路调用不同的overload方法 */

        // Approach 1: Brute Force
        // return climb_Stairs(0, n);


        // Approach 2: Recursion with Memoization
        // int memo[] = new int[n + 1];
        //     // 迈2阶，则可能超限1阶，所以数组容量应大1位
        // return climb_Stairs(0, n, memo);


        // Approach 3: Dynamic Programming
        // 这个是最好理解的，要能运用
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Brute Force
    // public int climb_Stairs(int i, int n) {

    /*
     * 这个递推的实现方法，很有意思
     * 思路：从0开始，每步尝试1阶和2阶，不超限就+1
     * 这个结构不好理解的就在于if中的return与最终的return的关系
     *
     */
    // if (i > n) {
    //     return 0;
    // }
    // if (i == n) {
    //     return 1;
    // }

    // return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);


    // Recursion with Memoization
    // public int climb_Stairs(int i, int n, int memo[]) {
    //
    //     /*
    //      * store the result at each step in memo array
    //      * and directly returning the result from the memo array
    //      * whenever that function is called again.
    //      *
    //      * */
    //
    //     if (i > n) {
    //         return 0;
    //     }
    //     if (i == n) {
    //         return 1;
    //     }
    //     if (memo[i] > 0) {
    //         return memo[i];
    //     }
    //
    //     memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
    //     return memo[i];
    // }
}
