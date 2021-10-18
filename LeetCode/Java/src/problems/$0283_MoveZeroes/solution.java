package problems.$0283_MoveZeroes;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        solution self = new solution();

        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums1));
        self.moveZeroes(nums1);

        System.out.println(Arrays.toString(nums1));

    }
    public void moveZeroes(int[] nums) {

        // Approach 1: 在数组内直接完成
        /*
         * 用一个变量当指针，遇到不是0的元素，将后一位的元素向前移动
         * 从执行情况看，相当于交换0与后一位元素的位置
         * 就是将0不断向后移动
         *
         * */

        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != pos) {
                    nums[pos] = nums[i];
                    nums[i] = 0;
                }
                pos++;
            }
        }
    }
}
