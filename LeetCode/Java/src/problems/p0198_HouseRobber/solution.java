package problems.p0198_HouseRobber;

public class solution {
    public static void main(String[] args) {
        solution self = new solution();
        int[] nums1 = new int[]{2, 7, 9, 3, 1};
        int[] nums2 = new int[]{2, 1, 1, 2};
        int[] nums3 = new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146,
                53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165,
                195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188,
                67, 205, 94, 205, 169, 241, 202, 144, 240};

        System.out.println(self.rob(nums1));    // 12
        // System.out.println(self.rob(nums2));    // 4
        // System.out.println(self.rob(nums3));    // 4
    }

    int[] memo;

    public int rob(int[] nums) {

        // Approach 1: Recursive + memo (top-down)
        // memo = new int[nums.length + 1];
        // Arrays.fill(memo, -1);  // memo全部填充为 -1
        // return rob_House(nums.length - 1, nums);



        // Approach 3: Iterative + memo (bottom-up)

        /*
         * 思路：
         * 这个才是爬楼梯那个dynamic process
         *
         * */
        // if (nums.length == 0) {
        //     return 0;
        // }
        // int[] dp = new int[nums.length + 1];
        // dp[0] = 0;
        // dp[1] = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        // }
        // return dp[nums.length];


        // Approach 4: Iterative + 2 variables (bottom-up)

        /*
         * 思路：推荐
         * 和Approach 2: Other Recursive其实是一样的
         * 但这个思路的变量命名，更清晰、更好理解一些，推荐学习这个
         *
         * 相比Approach 3: Iterative + memo，
         * 代码实现更初级（不用考虑指针），更好理解，一定要理解、运用
         * 主要的是迭代的实现方法，具体是用dp[]数组还是2个变量，不重要
         *
         * */

        if (nums.length == 0) {
            return 0;
        }
        // the order is: {prev2, prev1, num}
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            // 取较大者，因为相邻屋不能同时进入，这样想就好理解了。
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;


        // Approach 2: Other Recursive

        /*
         * 总体思路相同，但对于最高价值的判断更简练（更难理解）
         * 不好逐行进行解释，设想4个节点的情形{1,2,4,1}，分析其判断
         * 1号屋，rob=0，notrob=0->currob=1->notrob=0->rob=1
         * 2号屋，rob=1，notrob=0->currob=2->notrob=1->rob=2
         * 3号屋，rob=2，notrob=1->currob=5->notrob=2->rob=5
         * 4号屋，rob=5，notrob=2->currob=3->notrob=5->rob=3
         * 这里一定要注意3个刷新赋值的顺序
         *
         * */

        // int rob = 0; // max monney can get if rob current house
        // int notrob = 0; // max money can get if not rob current house
        // for (int i = 0; i < nums.length; i++) {
        //     // if rob current value, previous house must not be robbed
        //     // 进入当前屋子的收益：不进入前一个的收益+当前屋子的收益
        //     int currob = notrob + nums[i];
        //     // if not rob ith house, take the max value
        //     // of robbed (i-1)th house and not rob (i-1)th house
        //     // 不进入当前屋子的收益：不进去前一个屋子，与进入前一个屋子中的收益较大者
        //     notrob = Math.max(notrob, rob);
        //     // 进入当前屋子的累积收益
        //     rob = currob;
        // }
        // return Math.max(rob, notrob);
    }

    // Approach 1: Recursive + memo (top-down) 配套方法，用来递归
    public int rob_House(int i, int[] nums) {
        if (i < 0) {
            return 0;
        }
        // 作用？
        // 我觉得：由于是递归，前面的i已经求出值了
        // 后续再递归时就直接给值，缩短运行时间
        if (memo[i] >= 0) {
            return memo[i];
        }
        int rob = Math.max(rob_House(i - 2, nums) + nums[i],
                rob_House(i - 1, nums));
        // 作用？
        // 我觉得：将当前i的值存储起来，在以后递归到这里时，直接给值
        memo[i] = rob;
        return rob;
    }

}
