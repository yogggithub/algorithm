package $0448_FindAllNumbersDisappearedinanArray;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class self {
    public static void main(String[] args) {

        self self = new self();
        int[] nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = new int[]{1, 1};
        int[] nums3 = new int[]{1, 1, 2, 2};
        System.out.println(self.findDisappearedNumbers(nums1));
        System.out.println(self.findDisappearedNumbers(nums2));
        System.out.println(self.findDisappearedNumbers(nums3));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        // Method 1: 排序后判断是否跳数
        // 这个思路不太对，比如[1, 1, 1]，这个思路就求不出来
        // List<Integer> list = new LinkedList<>();
        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[0] != 1) {
        //         list.add(1);
        //     }
        //     if (nums[i] - nums[i - 1] > 1) {
        //         for (int j = 1; j < nums[i] - nums[i - 1]; j++) {
        //             list.add(nums[i] - j);
        //         }
        //     }
        // }
        // return list;

        // Method 2: 定一个指针
        // 解决不了[1, 1, 2, 2]
        // List<Integer> list = new LinkedList<>();
        // int index = 2;
        // Arrays.sort(nums);
        // if (nums.length == 0) {
        //     return list;
        // }
        // if (nums[0] != 1) {
        //     list.add(1);
        // } else if (nums[nums.length - 1] != nums.length) {
        //     list.add(nums.length);
        // }
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] != nums[i - 1]) {
        //         while (nums[i] - index != 0) {
        //             list.add(index++);
        //         }
        //         index++;
        //     }
        // }
        // return list;

        // Method 3: Map
        List<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;

        // Runtime: 30 ms, faster than 11.93% of Java online submissions for Find All Numbers Disappeared in an Array.
        // Memory Usage: 53.2 MB, less than 15.09% of Java online submissions for Find All Numbers Disappeared in an Array.
    }
}
