package solutions.p0027_RemoveElement;

public class P0027 {
    public int removeElement(int[] nums, int val) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 39.4 MB @ (beats) 11.70%
         */
        // int left = 0, right = nums.length - 1;
        // int ans = 0;
        // while (left <= right) {
        //     if (nums[left] == val) {
        //         while (right >= 0 && nums[right] == val) {
        //             right--;
        //         }
        //         if (right < 0 || right <= left) {
        //             break;
        //         }
        //         int temp = nums[left];
        //         nums[left] = nums[right];
        //         nums[right] = temp;
        //         right--;
        //     }
        //     ans++;
        //     left++;
        // }
        // return ans;

        /*
         * (learn from Internet)
         * Solution v2: Optimize
         */
        // idea
        // the problem says:
        // It does not matter what you leave beyond the returned k
        // thus, no need to switch the elements
        // just move retained element to front
        if (nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int num : nums) {
            if (num != val) {
                nums[ans++] = num;
            }
        }
        return ans;
    }
}
