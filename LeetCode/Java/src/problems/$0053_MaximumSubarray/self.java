package problems.$0053_MaximumSubarray;

/*
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and
 * return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 */

public class self {
    public static void main(String[] args) {
        self self = new self();
        int[] num1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] num2 = new int[]{1};
        int[] num3 = new int[]{-1};

        System.out.println(self.maxSubArray(num1));
        System.out.println(self.maxSubArray(num2));
        System.out.println(self.maxSubArray(num3));

    }

    public int maxSubArray(int[] nums) {

        // submission 1~3: Brute Force

        int temp2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp1 = nums[i];
            if (temp2 < temp1){
                temp2 = temp1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                temp1 += nums[j];
                if (temp1 > temp2) {
                    temp2 = temp1;
                }
                if (j == nums.length - 1) {
                    temp1 = 0;
                }
            }
        }
        return temp2;

        // Runtime: 61 ms, faster than 5.02% of Java online submissions for Maximum Subarray.
        // Memory Usage: 40.4 MB, less than 5.16% of Java online submissions for Maximum Subarray.


        // submission
        //
    }
}
