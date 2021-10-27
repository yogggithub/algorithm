package top_interview_questions.easy.math;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 11 ms @ (beats) 76.48%
         * Memory Usage: 38.8 MB @ (beats) 72.41%
         */
        if (n <= 0 || n == 2) {
            return false;
        } else if (n == 1 || n == 3) {
            return true;
        }

        int left = 3, right = n;
        while (left <= right) {
            if (right % 3 != 0) {
                return false;
            }
            if (left == right) {
                return true;
            }
            left *= 3;
            right /= 3;
        }
        if (left == right * 3) {
            return true;
        }
        return false;


        /*
         * (learn from Internet)
         * Solution v2:
         */

        // if (n < 1) {
        //     return false;
        // }
        //
        // while (n % 3 == 0) {
        //     n /= 3;
        // }
        //
        // return n == 1;
    }
}
