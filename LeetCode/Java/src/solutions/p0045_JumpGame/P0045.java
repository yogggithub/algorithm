package solutions.p0045_JumpGame;

public class P0045 {
    public int jump(int[] nums) {

        int ans = 0;
        int next = 0;
        int reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, i + nums[i]);

            if (i == reachable) {
                ans++;
                reachable = next;
            }
        }
        return ans;
    }
}
