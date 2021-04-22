package $0001_TwoSum;

/*
 * Two Sum
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * <p>
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */


class self {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    
                }
            }
        }
        return result;

        // Runtime: 28 ms, faster than 15.42% of Java online submissions for Two Sum.
        // Memory Usage: 38.5 MB, less than 56.17% of Java online submissions for Two Sum.
    }
}
