package problems.p0198_HouseRobber;

public class P0198 {
    public static void main(String[] args) {
        P0198 self = new P0198();
        int[] nums1 = new int[]{2, 7, 9, 3, 1};
        int[] nums2 = new int[]{2, 1, 1, 2};
        int[] nums3 = new int[]{114,117,207,117,235,82,90,67,143,146,
                53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,
                195,187,199,114,235,197,187,69,129,64,214,228,78,188,
                67,205,94,205,169,241,202,144,240};

        System.out.println(self.rob(nums1));    // 12
        System.out.println(self.rob(nums2));    // 4
        System.out.println(self.rob(nums3));    // 4173
    }

    public int rob(int[] nums) {

        // 自己只做出来80%，整体code改错是看了答案之后进行的
        /*
         * 思路基本是正确的，但存在个别需要优化的地方
         * 优化一：考虑问题时，要转变思路，不是 -2/-3，而是 -1+当前/-2
         * 优化二：递归调用时，不用考虑i超出数组指针的问题，而是要给递归一个出口
         *        这里并不是说完全不考虑数组指针（nums[i]这种还得保证指针），而是递归本身只需要出口条件
         * 优化三：递归出口的选定，结合数组指针，0~length，所以不能<0
         *
         * */

        // return rob_House(nums.length - 1, nums);
        // 超时
        // 原因：process the same i multiple times


        // 自己尝试写一个dynamic process
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];

        // Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
        // Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for House Robber.
    }

    public int rob_House(int i, int[] nums) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob_House(i - 2, nums) + nums[i],
                rob_House(i - 1, nums));
    }


}
