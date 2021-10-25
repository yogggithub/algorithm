package top_interview_questions.easy.dynamic;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
        System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {

        /*
         * Solution v1.1: Recursive
         *
         * It is correct but exceed time limitation
         */
        // base case
        // if (n == 1) {
        //     return 1;
        // }
        // if (n == 2) {
        //     return 2;
        // }
        // if (n == 3) {
        //     return 3;
        // }
        // return climbStairs(n - 1) + climbStairs(n - 2);

        /*
         * Solution v2.1: Iterative
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 35.9 MB @ (beats) 57.30%
         */

        // Use an array to store all the result
        // thus, be able to get previous the result of two steps
        // int[] steps = new int[n + 1];
        // steps[0] = 0;   // dummy
        // steps[1] = 1;
        // steps[2] = 2;
        // for (int i = 3; i < steps.length; i++) {
        //     steps[i] = steps[i - 1] + steps[i - 2];
        // }
        // return steps[n];


        /*
         * Solution v2.2: Iterative Optimize
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 37.5 MB @ (beats) 39.3%
         */

        // donot store the result
        // repeat sum two previous until reach n
        int zero = 1;   // n = 0
        int one = 1;    // n = 1

        // from n = 2, every  result should be n-1 + n-2
        while (n-- > 0) {
            one += zero;
            zero = one -zero;   // get one's value before sum
        }
        return one;
    }
}
