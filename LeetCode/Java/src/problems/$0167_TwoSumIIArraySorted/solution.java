package problems.$0167_TwoSumIIArraySorted;

public class solution {

    // solution is locked, requires subscription to unlock
    public int[] twoSum(int[] nums, int target) {

        // 不用HashMap
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int tar = nums[left] + nums[right];
            if (tar == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (tar > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
        // Memory Usage: 38 MB, less than 96.27% of Java online submissions for Two Sum II - Input array is sorted.
    }
}
