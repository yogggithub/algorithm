package solutions.p0238_ProductOfArrayExceptSelf;

public class P0238 {
    public int[] productExceptSelf(int[] nums) {
        /*
         * Solution v1.1: Brute Force
         *
         * Time Limit Exceeded
         */
        // int[] ans = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     int temp = 1;
        //     for (int j = 0; j < nums.length; j++) {
        //         if (j == i) {
        //             continue;
        //         }
        //         temp *= nums[j];
        //         ans[i] = temp;
        //     }
        // }
        // return ans;

        /*
         * Solution v1.2: Optimize
         *
         * Runtime: 2 ms @ (beats) 42.73%
         * Memory Usage: 57 MB @ (beats) 16.50%
         */
        // idea:
        // if there is one zero, ans should be zero except the 0 element
        // if there are more than one zero, ans should be all zero
        // otherwise, calculate a total product
        // for every element in ans, divide corresponding element to reduce run time
        // int temp = 1;
        // int zero = 0;
        // for (int num : nums) {
        //     if (num == 0) {
        //         zero++;
        //         continue;
        //     }
        //     temp *= num;
        // }
        // int[] ans = new int[nums.length];
        // if (zero == 1) {
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] == 0) {
        //             ans[i] = temp;
        //         }
        //     }
        // } else if (zero == 0){
        //     for (int i = 0; i < nums.length; i++) {
        //         ans[i] = temp / nums[i];
        //     }
        // }
        // return ans;

        /*
         * (learn from Internet)
         * Solution v2: Two rounds
         */
        // idea
        // first round get product for all elements before current
        // second round multiple all element after current.
        int length = nums.length;
        int ans[] = new int[length];

        ans[0] = 1;
        //Product to the left
        for (int i = 1; i < length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int right = 1;
        //Multiply it by Product to the right
        for (int i = length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];

        }

        return ans;
    }
}
