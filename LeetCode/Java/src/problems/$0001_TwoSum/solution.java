package problems.$0001_TwoSum;


import java.util.HashMap;

class solution {
    public int[] twoSum(int[] nums, int target) {

        // Approach 1: Brute Force 蛮力....
        // for (int i = 0; i < nums.length; i++) {
        //     // i实际不用取到最后一位，所以我觉得我的 length - 1更好
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] == target - nums[i]) {
        //             return new int[]{i, j};
        //             // 这里的return会更简练一些
        //         }
        //     }
        // }
        // throw new IllegalArgumentException("No two sum solution");


        // Approach 2: Two-pass Hash Table
        /*
         * What is the best way to maintain a mapping of each element in the array to its index? A hash table.
         * A hash table is built exactly for this purpose, it supports fast look up in near constant time.
         *
         * 理解：
         * HashMap通过hashcode对其内容进行快速查找
         * HashMap对象在这里有两个参数，第一个是元素值，第二个是索引
         * get()来获取value，put()来插入value，ContainsKey()则用来检验对象是否已经存在
         *
         * 以求差值来确定需要找的值，然后查找HashMap中是否有这个值，且这个值不能是本身
         * 最后将两个索引放到return中。
         *
         */

        HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], i);
            // 把原数组每个元素都放进hashMap中
        // for (int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
        //     if (map.containsKey(complement) && map.get(complement) != i) {
        //         return new int[]{i, map.get(complement)};
        //     }
        // }


        // Approach 3: One-pass Hash Table
        /*
         * 在Approach2中，向HashMap插入元素时，立即寻找是否已有元素符合差值
         * 符合立即输出
         *
         */

        // Map的declare见上
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
               // 这里为什么不判断i是不是自身？因为i元素还没插入到HashMap中
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
