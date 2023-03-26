package solutions.p2348_NumberofZeroFilledSubarrays;

public class P2348 {
    public long zeroFilledSubarray(int[] nums) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 3 ms @ (beats) 99.69%
         * Memory Usage: 60.1 MB @ (beats) 27.27%
         */
        // long ans = 0;
        // long sub = 0;
        //
        // for (int n : nums) {
        //     if (n == 0) {
        //         sub++;
        //     } else {
        //         sub = 0;
        //     }
        //     ans += sub;
        // }
        // return ans;

        /*
         * Solution v2: Two pointer
         *
         * Runtime: 3 ms @ (beats) 99.69%
         * Memory Usage: 59.9 MB @ (beats) 41.69%
         */
        long ans = 0;
        int l = nums.length;
        int j = -1;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                ans += i - j;
            } else {
                j = i;
            }
        }
        return ans;
    }
}
