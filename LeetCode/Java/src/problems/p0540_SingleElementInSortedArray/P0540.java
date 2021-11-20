package problems.p0540_SingleElementInSortedArray;

public class P0540 {
    public int singleNonDuplicate(int[] nums) {
        /*
         * Solution v1: XOR
         * this is not a O(log n) solution
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 39.2 MB @ (beats) 61%
         */
        // int xor = 0;
        // for (int num : nums) {
        //     xor ^= num;
        // }
        //
        // return xor;

        /*
         * (learn from Internet)
         * Solution v2: Binary Search
         */
        int left = 0, right = nums.length - 1;

        while (left < right) {
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            //            ^
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            // We didn't find a pair. The single element must be on the left.
            // (pipes mean left & right)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            }

            // We found a pair. The single element must be on the right.
            // Example: |1 1 3 3 5 6 6|
            //               ^ ^
            // Next:     1 1 3 3|5 6 6|
            else {
                left = mid + 2;
            }
        }

        // 'start' should always be at the beginning of a pair.
        // When 'left > right', start must be the single element.
        return nums[left];
    }
}
