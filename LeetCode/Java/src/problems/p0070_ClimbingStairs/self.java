package problems.p0070_ClimbingStairs;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 */


public class self {
    public static void main(String[] args) {
        self self = new self();

        System.out.println(self.climbStairs(2));
        System.out.println(self.climbStairs(3));
        System.out.println(self.climbStairs(4));
    }

    public int climbStairs(int n) {

        // submission 1
        // 列举了4~6的情况，发现符合斐波那契函数，以通项公式求结果
        if (n == 1){
            return 1;
        }else{
            return (int) (1/Math.sqrt(5)
                            * ((Math.pow((1+Math.sqrt(5))/2, n+1))
                            - (Math.pow((1-Math.sqrt(5))/2, n+1))));
        }

        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
        // Memory Usage: 32.7 MB, less than 5.26% of Java online submissions for Climbing Stairs.


        // submission 2
        // Brute Force

    }
}
