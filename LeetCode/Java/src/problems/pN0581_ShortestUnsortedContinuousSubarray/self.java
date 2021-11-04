package problems.pN0581_ShortestUnsortedContinuousSubarray;

/*
 * Given an integer array, you need to find one continuous subarray
 * that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order
 * to make the whole array sorted in ascending order.
 *
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 * */

public class self {
    public static void main(String[] args) {
        self self = new self();
        int[] nums1 = new int[]{2, 6, 4, 8, 10, 9, 15};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{1, 3, 2, 4};
        int[] nums4 = new int[]{1};
        int[] nums5 = new int[]{1, 2};
        int[] nums6 = new int[]{1, 3, 2, 2, 2};
        System.out.println(self.findUnsortedSubarray(nums1));
        System.out.println(self.findUnsortedSubarray(nums2));
        System.out.println(self.findUnsortedSubarray(nums3));
        System.out.println(self.findUnsortedSubarray(nums4));
        System.out.println(self.findUnsortedSubarray(nums5));
        System.out.println(self.findUnsortedSubarray(nums6));
    }

    public int findUnsortedSubarray(int[] nums) {
        // 没做出来
        // 这个思路提交了7次，但一直通不过测试
        int max = 0, min = nums.length - 1;
        if (nums.length < 2) {
            return 0;
        } else if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 2;
            } else {
                return 0;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (min > i) {
                    min = i;
                }
                if (max < i) {
                    max = i;
                }
            } else if (nums[i] == nums[i - 1]){
                max++;
            }
        }
        return Math.max(max - min + 2, 0);
    }
}
