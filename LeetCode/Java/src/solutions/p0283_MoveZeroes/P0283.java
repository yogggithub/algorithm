package solutions.p0283_MoveZeroes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P0283 {
    public static void main(String[] args) {
        P0283 self = new P0283();

        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums1));
        self.moveZeroes(nums1);

        System.out.println(Arrays.toString(nums1));

    }

    public void moveZeroes(int[] nums) {

        // Brute Force

        // version 1
        // Stack<Integer> stack = new Stack<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         stack.push(nums[i]);
        //     }
        // }
        // for (int i = stack.size(); i < nums.length; i++) {
        //     nums[i] = 0;
        // }
        // for (int i = stack.size() - 1; i >= 0 ; i--) {
        //     nums[i] = stack.pop();
        // }
        // Runtime: 2 ms, faster than 16.08% of Java online submissions for Move Zeroes.
        // Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Move Zeroes.

        // version 2: 减少循环
        // 但效率没本质差异
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                queue.offer(nums[i]);
            }
        }
        int count = queue.size();
        for (int i = 0; i < nums.length; i++) {
            if (i < count) {
                nums[i] = queue.poll();
            } else {
                nums[i] = 0;
            }
        }
        // Runtime: 1 ms, faster than 18.95% of Java online submissions for Move Zeroes.
        // Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Move Zeroes.

    }
}
