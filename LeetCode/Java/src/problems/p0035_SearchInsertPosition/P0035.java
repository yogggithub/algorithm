package problems.p0035_SearchInsertPosition;

/*
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Example 4:
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 *
 * Example 5:
 * Input: nums = [1], target = 0
 * Output: 0
 */
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
