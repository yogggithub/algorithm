package problems.$0136_SingleNumber;

import java.util.ArrayList;
import java.util.List;

public class solution {

    public static void main(String[] args) {

        solution self = new solution();

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

        // Approach 1: List operation
        /*
         * 思路：
         * 只针对list操作，重复就删掉，不重复就加入
         *
         * */
        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (list.indexOf(nums[i]) == -1) {
        //         list.add(nums[i]);
        //     } else {
        //         list.remove(list.indexOf(nums[i]));
        //     }
        // }
        // return list.get(0);

        // Runtime: 109 ms, faster than 5.02% of Java online submissions for Single Number.
        // Memory Usage: 40.7 MB, less than 74.08% of Java online submissions for Single Number.


        // Approach 2: Hash Table
        /*
         * 整体思路和list类似，只不过使用HashTable
         * */
        // Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        // for (int num : nums) {
        //     if (hashtable.containsKey(num)) {
        //         hashtable.remove(num);
        //     } else {
        //         hashtable.put(num, 1);
        //     }
        // }

        // Hashtable的get返回的是索引，输出内容需要遍历

        // int ans = 0;
        // 法一：别人的
        // Set<Integer> keys = hashtable.keySet();
        //    // 使用Set的原因：Set是元素唯一的collection（补充知识中有）
        // for (Integer key : keys) {
        //     ans = key;
        // }

        // 法二：自己的
        // for (int num : nums) {
        //     if (hashtable.get(num) != null){
        //         ans = num;
        //     }
        // }
        // return ans;


        // Approach 3: Math
        // 2∗(a+b+c)−(a+a+b+b+c)=c
        int sum_nodup = 0, sum_all = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            sum_all += num;
            if (!list.contains(num)) {
                sum_nodup += num;
                list.add(num);
            }
        }
        return 2 * (sum_nodup) - sum_all;


        // Approach 4: Bitwise
        /*
         * 补充：
         * ^ 在Bitwise中是 XOR运算，i.e. 0 ^ N = N，N ^ N = 0
         * 所以在连续运算后，其结果就是唯一的单独数字
         *
         * */
        // int ans = 0;
        // for (int num : nums) {
        //     ans ^= num;
        // }
        // return ans;
    }
}
