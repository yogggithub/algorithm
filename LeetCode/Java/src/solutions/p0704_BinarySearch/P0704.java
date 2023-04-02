package solutions.p0704_BinarySearch;

public class P0704 {
    public int search(int[] nums, int target) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 43.2 MB @ (beats) 47.4%
         */

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
