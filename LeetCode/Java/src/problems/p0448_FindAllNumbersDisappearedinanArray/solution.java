package problems.p0448_FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void main(String[] args) {

        solution self = new solution();
        int[] nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = new int[]{1, 1};
        int[] nums3 = new int[]{1, 1, 2, 2};
        System.out.println(self.findDisappearedNumbers(nums1));
        System.out.println(self.findDisappearedNumbers(nums2));
        System.out.println(self.findDisappearedNumbers(nums3));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        // Approach 1: Marked to negative
        /*
         * 思路：为什么结果是 index +　１？其本源思路是怎样的？
         * 我的理解：index是number - 1，先把数组全转成负数，
         * 则剩下的正数说明其index没被查到过。
         * 而index + 1就是原数组缺失的数字
         * 其思路的核心在于建立数字与index的关系
         * because the numbers is from 1 to n, so the index of array should
         * be numbers - 1. turn the nums[nums[i]-1] to negative.
         * when iterate the array again, the positive numbers are that did
         * not be marked.
         *
         * for example: [4, 3, 2, 7, 8, 2, 3, 1]
         * index for array (num[i] - 1): [3, 2, 1, 6, 7, 1, 2, 0]
         * iterate 1st, turn element to negative
         * when i = 0: index = 3, result -> [4, 3, 2, -7, 8, 2, 3, 1]
         * when i = 1: index = 2, resuly -> [4, 3, -2, -7, 8, 2, 3, 1]
         * and so on, the array become [-4, -3, -2, -7 ,8, 2, -3, -1]
         * interate 2nd, look for the positive numbers
         * [8, 2] -> nums[4] = 8 and nums[5] = 2
         * add the index + 1 to the list
         *
         * */

        // List<Integer> ret = new ArrayList<Integer>();
        //
        // for (int i = 0; i < nums.length; i++) {
        //     // 因为可能有元素被变成负数，所以要abs
        //     int val = Math.abs(nums[i]) - 1;
        //     if (nums[val] > 0) {
        //         nums[val] = -nums[val];
        //     }
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > 0) {
        //         ret.add(i + 1);
        //     }
        // }
        // return ret;


        // Approach 2: 和Approach 1类似，是另一种实现思路

        // List<Integer> res = new ArrayList<>();
        // int n = nums.length;
        // for (int i = 0; i < nums.length; i++) {
        //     // 这其实就是通过建立数字与index的关系，转换原数组中数字
        //     // 在Approach 1中，其关系是 nums[nums[i]-1] = -nums[nums[i]-1]
        //     nums[(nums[i] - 1) % n] += n;
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] <= n) {
        //         res.add(i + 1);
        //     }
        // }
        // return res;


        // Approach 3: Swap numbers
        /*
         * if nums[i] != i + 1 and nums[i] != nums[nums[i] - 1],
         * then we swap nums[i] with nums[nums[i] - 1]
         * In the end the array will be sorted and if nums[i] != i + 1,
         * then i + 1 is missing
         *
         * for example: [4, 3, 2, 7, 8, 2, 3, 1]
         * nums[0] = 4 and nums[3] = 7, swap the two numbers [7,3,2,4,8,2,3,1]
         *
         * at last, the array become [1,2,3,4,3,2,7,8]
         *
         * */

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
