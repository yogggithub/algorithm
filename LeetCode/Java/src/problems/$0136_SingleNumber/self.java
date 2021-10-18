package problems.$0136_SingleNumber;


/*
 * Given a non-empty array of integers,
 * every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class self {

    public static void main(String[] args) {

        self self = new self();

        int[] nums1 = new int[]{4, 1, 2, 1, 2};
        int[] nums2 = new int[]{2, 2, 1};
        int[] nums3 = new int[]{1, 0, 1};
        int[] nums4 = new int[]{1, 3, 1, -1, 3};


        System.out.println(self.singleNumber(nums1));
        System.out.println(self.singleNumber(nums2));
        System.out.println(self.singleNumber(nums3));
        System.out.println(self.singleNumber(nums4));

    }


    public int singleNumber(int[] nums) {

        // Brute Force
        int num = 0, index = 0;
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] == nums[j]) {
                        arr[index] = nums[i];
                        index++;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < index; i++) {
            list.add(i, arr[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.indexOf(nums[i]) == -1){
                num = nums[i];
            }
        }
        return num;

        // Runtime: 826 ms, faster than 5.02% of Java online submissions for Single Number.
        // Memory Usage: 39.3 MB, less than 97.04% of Java online submissions for Single Number.


        // optimized
        // 没完全做出来
        // if (nums.length == 1) {
        //     return nums[0];
        // }
        //
        // List<Integer> list = new ArrayList<Integer>();
        // for (int i = 0; i < nums.length; i++) {
        //     list.add(i, nums[i]);
        // }
        //
        // int length = nums.length;
        // for (int j = 0; j < length; j++) {
        //     // int num = nums[i];
        //     if (list.indexOf(nums[j]) != -1 && list.indexOf(nums[j]) != j) {
        //         list.remove(list.indexOf(nums[j]));
        //         j--;
        //         length--;
        //         list.remove(list.indexOf(nums[j]));
        //         j--;
        //         length--;
        //     }
        // }
        // return list.get(0);


    }
}
