package top_interview_questions.medium.arrays_strings;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 44 ms @ (beats) 0%
         * Memory Usage: 81 MB @ (beats) 49.04%
         */
        // // special case: large array but only contain two value [1,2]
        // int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // for (int num : nums) {
        //     if (min > num) {
        //         min = num;
        //     }
        //     if (max < num) {
        //         max = num;
        //     }
        // }
        // if (min >= max - 1) {
        //     return false;
        // }
        //
        // // regular procedure
        // for (int i = 1; i < len; i++) {
        //     int smaller = i - 1;
        //     while (smaller >= 0 && nums[smaller] >= nums[i]) {
        //         smaller--;
        //     }
        //     if (smaller < 0) {
        //         continue;
        //     }
        //     int larger = i + 1;
        //     while (larger < len && nums[larger] <= nums[i]) {
        //         larger++;
        //     }
        //     if (larger >= len) {
        //         continue;
        //     }
        //     if (nums[smaller] < nums[i] &&
        //         nums[larger] > nums[i]) {
        //         return true;
        //     }
        // }
        //


        /*
         * (learn from Internet)
         * Solution v2: chain assignment
         */
        // idea:
        // take advantage of continuous comparison and if statements
        // find smallest value by first if condition
        // then find smaller value by second else-if condition
        // eventually the largest value go inside else block
        // and that means the required comparison succeeded
        int smallest = Integer.MAX_VALUE;
        int smaller = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= smallest) {
                smallest = n;
            } else if (n <= smaller) {
                smaller = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
