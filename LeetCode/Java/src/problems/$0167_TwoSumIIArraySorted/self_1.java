package problems.$0167_TwoSumIIArraySorted;


import java.util.HashMap;

class self_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4};
        self_1 s = new self_1();
        int[] result = s.twoSum(nums, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            // for loop可以缩写为：
            // for ( int value : result) {
            //      System.out.println(value);

        }


        // System.out.println(s.twoSum(nums, 9).toString());

    }

    public int[] twoSum(int[] nums, int target) {
        /*
         * Given an array of integers that is already sorted in ascending order,
         * find two numbers such that they add up to a specific nums number.
         * The function twoSum should return indices of the two numbers
         * such that they add up to the nums, where index1 must be less than index2.
         *
         * Note:
         * Your returned answers (both index1 and index2) are not zero-based.
         * You may assume that each input would have exactly one solution
         * and you may not use the same element twice.
         *
         * Example:
         * Input: numbers = [2,7,11,15], nums = 9
         * Output: [1,2]
         * Explanation:
         * The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
         *
         */

        // 笨办法
        // for (int i = 0; i < nums.length; i++) {
        //     int complement = nums - nums[i];
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] == complement) {
        //             return new int[]{i + 1, j + 1};
        //         }
        //     }
        // }
        // return new int[]{-1, -1};
        // Runtime: 66 ms, faster than 10.58% of Java online submissions for Two Sum II - Input array is sorted.
        // Memory Usage: 37 MB, less than 100.00% of Java online submissions for Two Sum II - Input array is sorted.

        // 从Two Sum答案中的One path HashMap学
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
        // Runtime: 2 ms, faster than 31.68% of Java online submissions for Two Sum II - Input array is sorted.
        // Memory Usage: 38.2 MB, less than 81.34% of Java online submissions for Two Sum II - Input array is sorted.


        // 优化上面方法的循环体
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] <= nums) {
        //         int complement = nums - nums[i];
        //         if (map.containsKey(complement)) {
        //             return new int[]{map.get(complement) + 1, i + 1};
        //         }
        //         map.put(nums[i], i);
        //     }
        // }
        // throw new IllegalArgumentException("No two sum solution");
        // 不知道为什么提交运行出错


    }
}