package problems.$0169_MajorityElement;

/*
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and
 * the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * */

import java.util.HashMap;

public class self {
    public int majorityElement(int[] nums) {

        /*
         * 问题：
         * 对题目理解不到位
         * 题目中明确了主要数字的出现次数必大于n/2次
         * 所以本题有更简练的解法
         *
         * 此外，list的用法也不合理
         * HashMap要求的key-value对不能重复
         * 所以，可以直接使用HashMap来记录每个元素及出现次数
         *
         * */


        // version 1
        // List<Integer> list = new ArrayList<>();
        //
        // for (int num : nums) {
        //     if (!list.contains(num)) {
        //         list.add(num);
        //     }
        // }
        //
        // int count = 0, max = Integer.MIN_VALUE, result = 0;
        // int[] key = new int[list.size() + 1];
        // for (int num : nums) {
        //     count = key[list.indexOf(num)];
        //     count++;
        //     key[list.get(num)] = count;
        //
        //     if (max <= count) {
        //         max = count;
        //         result = list.get(list.indexOf(num));
        //     }
        // }
        // return result;

        //Runtime: 8 ms, faster than 49.68% of Java online submissions for Majority Element.
        // Memory Usage: 42 MB, less than 64.71% of Java online submissions for Majority Element.


        // version 2: 简化循环
        // 没有明显的效率提升，仅是内存使用下降
        // List<Integer> list = new ArrayList<>();
        // int count = 0, max = Integer.MIN_VALUE, result = 0;
        // int[] key = new int[nums.length];
        //
        // for (int num : nums) {
        //     if (!list.contains(num)) {
        //         list.add(num);
        //     }
        //     count = key[list.indexOf(num)];
        //     count++;
        //     key[list.indexOf(num)] = count;
        //     if (max <= count) {
        //         max = count;
        //         result = list.get(list.indexOf(num));
        //     }
        // }
        // return result;

        //Runtime: 11 ms, faster than 45.58% of Java online submissions for Majority Element.
        // Memory Usage: 41 MB, less than 97.06% of Java online submissions for Majority Element.

        // version 3: HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        if (nums.length < 3) {
            return nums[0];
        }
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                count = hashMap.get(num) + 1;
                if (count > nums.length / 2) {
                    return num;
                }
                hashMap.put(num, count);
            }
        }
        return -1;

        // Runtime: 12 ms, faster than 40.64% of Java online submissions for Majority Element.
        // Memory Usage: 40.8 MB, less than 99.26% of Java online submissions for Majority Element.

    }
}
