package solutions.p0046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class P0046 {
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<List<Integer>> ans = new ArrayList<>();
        helper(new ArrayList<Integer>(), new boolean[nums.length], ans);
        return ans;
    }

    public void helper(List<Integer> curr, boolean[] is_used, List<List<Integer>> ans) {
        if (curr.size() == this.nums.length) {
            ans.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < this.nums.length; i++) {
            if (is_used[i]) {
                continue;
            }

            int n = this.nums[i];
            curr.add(n);
            is_used[i] = true;
            helper(curr, is_used,ans);
            curr.remove(curr.size() - 1);
            is_used[i] = false;
        }
    }
}
