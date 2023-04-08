package solutions.p2439_MinimizeMaximumofArray;

public class P2439 {
    public int minimizeArrayValue(int[] nums) {
        /*
         * Solution v1: Mving Average
         *
         * Runtime: 7 ms @ (beats) 97.13%
         * Memory Usage: 62 MB @ (beats) 46.24%
         */
        double ans = nums[0];
        double sub_total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sub_total += nums[i];
            double avg = Math.ceil(sub_total / (i + 1));
            if (avg > ans) {
                ans = avg;
            }
        }
        return (int) ans;
    }
}
