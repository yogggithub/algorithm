package problems.p0260_SingleNumberIII;

/*
 * Given an integer array nums,
 * in which exactly two elements appear only once
 * and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity
 * and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 *
 * Example 2:
 * Input: nums = [-1,0]
 * Output: [-1,0]
 *
 * Example 3:
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 * Constraints:
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 */

public class P0260 {
    public int[] singleNumber(int[] nums) {
        /*
         * Solution v1: Brute Force with Set
         *
         * Runtime: 3 ms @ (beats) 37.25%
         * Memory Usage: 39.5 MB @ (beats) 60.14%
         */
        // Set<Integer> isUnique = new HashSet<>();
        //
        // for (int num : nums) {
        //     if (!isUnique.add(num)) {
        //         isUnique.remove(num);
        //     }
        // }
        // int[] result = new int[2];
        // int i = 0;
        // for (Integer num : isUnique) {
        //     result[i++] = num;
        // }
        // return result;

        /*
         * Solution v2: Sort first
         *
         * Runtime: 3 ms @ (beats) 37.25%
         * Memory Usage: 39.5 MB @ (beats) 60.14%
         */
        // Arrays.sort(nums);
        // int[] result = new int[2];
        // int index = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     // corner case
        //     if (i == nums.length - 1) {
        //         result[1] = nums[i];
        //         break;
        //     } else if (nums[i] == nums[i + 1]) {
        //         // move loop index one step
        //         // and the loop itself would move another step
        //         // so actually two steps each loop
        //         i++;
        //     } else {
        //         result[index] = nums[i];
        //         index++;
        //     }
        // }
        // return result;

        /*
         * (learn from Internet)
         * Solution v3: XOR
         */
        int bitmask = 0;
        for (int num : nums) {
            bitmask = bitmask ^ num;
        }
        int diff = bitmask & (~bitmask + 1);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                x = x ^ num;
            }
        }
        return new int[]{x, x ^ bitmask};
    }
}
