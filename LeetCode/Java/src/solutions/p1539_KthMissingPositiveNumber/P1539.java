package solutions.p1539_KthMissingPositiveNumber;

public class P1539 {
    public static void main(String[] args) {

        P1539 solution = new P1539();

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(solution.findKthPositive(arr, k));   // 9

        arr = new int[]{1, 2, 3, 4};
        k = 2;
        System.out.println(solution.findKthPositive(arr, k));   // 6

        arr = new int[]{2};
        k = 1;
        System.out.println(solution.findKthPositive(arr, k));   // 1
    }

    public int findKthPositive(int[] arr, int k) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 42.2 MB @ (beats) 29.37%
         */

        // int count = 0;
        // int n = 1;
        //
        // for (int i = 0; i < arr.length; i++) {
        //     while (n < arr[i]){
        //         count++;
        //         if (count >= k){
        //             return n;
        //         }
        //         n++;
        //     }
        //     n++;
        // }
        //
        // int last = arr[arr.length - 1];
        // while (count < k) {
        //     last++;
        //     count++;
        // }
        // return last;

        /*
         * Solution v2: Binary
         *
         * Runtime:  ms @ (beats) %
         * Memory Usage:  MB @ (beats) %
         */
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
                n = mid;
            }
        }
        return n + k;

    }
}
