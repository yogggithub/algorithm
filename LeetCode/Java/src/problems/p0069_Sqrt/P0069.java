package problems.p0069_Sqrt;

public class P0069 {
    public int mySqrt(int x) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: ms @ (beats) %
         * Memory Usage: MB @ (beats) %
         */
        if (x <= 1) {
            return x;
        } else if (x <= 4) {
            return x / 2;
        } else if (x < 9) {
            return 2;
        }

        /*
         * Solution v1: Binary Search
         *
         * Runtime: 1 ms @ (beats) 99.99%
         * Memory Usage: 36.2 MB @ (beats) 58.12%
         */
        // int left = 1, right = x;
        // while (left <= right) {
        //     int mid = left + (right - left) / 2;
        //     // pay attention that multiple will cause overflow
        //     // thus better use division
        //     if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
        //         return mid;
        //     } else if (mid > x / mid) {
        //         right = mid - 1;
        //     } else {
        //         left = mid + 1;
        //     }
        // }
        // return left;

        /*
         * Solution v2: Brute Force
         *
         * Runtime: 217 ms @ (beats) 5.05%
         * Memory Usage: 38.5 MB @ (beats) 5.27%
         */
        // for (int i = 2; i <= x / i; i++) {
        //     if (i <= x / i && (i + 1) > x / (i + 1)) {
        //         return i;
        //     }
        // }
        // return -1;

        /*
         * (learn from Internet)
         * Solution v3: Newton
         */
        long i = x;
        while (i > x / i) {
            i = (i + x / i) / 2;
        }
        return (int) i;
    }
}
