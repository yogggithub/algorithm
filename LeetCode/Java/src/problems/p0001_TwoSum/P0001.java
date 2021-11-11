package problems.p0001_TwoSum;

class P0001 {
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
