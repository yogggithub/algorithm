package solutions.p0035_SearchInsertPosition;

public class P0035 {
    public int searchInsert(int[] nums, int target) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 6.69%
         * Memory Usage: 38.7 MB @ (beats) 60.03%
         */
        // int result = -1;
        // if (nums.length == 1) {
        //     result = target > nums[0] ? 1 : result;
        // }
        //
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (target == nums[i]) {
        //         result = i;
        //     } else if (target == nums[i + 1] ||
        //                (target > nums[i] && target < nums[i + 1])) {
        //         result = i + 1;
        //     } else if (i == nums.length - 2 && target > nums[i + 1]) {
        //         result = i + 2;
        //     } else if (i == 0 && target < nums[i]) {
        //         result = 0;
        //     }
        // }
        // return result;

        /*
         * Solution v2: Binary Search
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 39.1 MB @ (beats) 43.02%
         */
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
