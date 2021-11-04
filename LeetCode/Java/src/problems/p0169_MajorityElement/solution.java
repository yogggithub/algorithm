package problems.p0169_MajorityElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class solution {
    public static void main(String[] args) {
        solution solution = new solution();
        int[] nums1 = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(nums1));

    }

    public int majorityElement(int[] nums) {

        // Approach 1: Brute Force
        // 思路很简单，就是对每个元素在数组内计数，大于标准就return
        // int majorityCount = nums.length / 2;
        // for (int num : nums) {
        //     int count = 0;
        //     for (int elem : nums) {
        //         if (elem == num) {
        //             count += 1;
        //         }
        //     }
        //     if (count > majorityCount) {
        //         return num;
        //     }
        // }
        // return -1;

        // Approach 2: HashMap
        // 注意与自己写的HashMap比较的优化点

        // 优化：使用map而不是HashMap
        // Map<Integer, Integer> counts = countNums(nums);
        //
        // Map.Entry<Integer, Integer> majorityEntry = null;
        // // 这里我理解是对计数后的每一组key-value对
        // // 通过判断，比较每个key对应的value是否更大
        // // 更大则将majority更新，变成更大的key-value对
        // // 然后直接输出最大的key
        // for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        //     if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
        //         majorityEntry = entry;
        //     }
        // }
        // return majorityEntry.getKey();


        // Approach 3: Sorting

        /*
         * If the elements are sorted in monotonically increasing (or decreasing) order,
         * the majority element can be found at index ⌊n/2⌋
         * (and ⌊n/2⌋ + 1, incidentally, if n is even).
         *
         * 思路：数学思路
         * ⌊ ⌋，指取底，i.e. 求小于值的最大整数
         * 设想一个含有n个元素的数组，根据题意，majority元素个数必须大于 n/2
         * 考虑两个极端情况，majority是数组最大或最小的元素（仅解释最小的情况）
         * 最小元素若想符合majority要求，其所占位置至少覆盖数组的中点及中点 + 1
         *
         * */

        // Arrays.sort(nums);
        //     // 学会并运用这个数组排序的方法
        // return nums[nums.length/2];


        // Approach 4: Randomization

        /*
         * 思路：
         * 其本质还是Brute Force，随机找一个元素，然后进行计数、比较
         * 符合条件就输出
         * 但由于majority元素数量大，通过随机方法可以减少运行时间，提升效率
         *
         * */

        // Random rand = new Random();
        // int majorityCount = nums.length / 2;
        // while (true) {
        //     int candidate = nums[randRange(rand, 0, nums.length)];
        //     if (countOccurences(nums, candidate) > majorityCount) {
        //         return candidate;
        //     }
        // }


        // Approach 5: Divide and Conquer

        /*
         * 思路：迭代
         * 将数组分为左右两个部分，分别求各自的majority元素
         * 如果两个结果相同，直接输出；如果不同，则比较计数，输出较大者
         * 然后通过迭代，不断细分、输出
         *
         * */

        // return majorityElementRec(nums, 0, nums.length - 1);


        // Approach 6: Boyer-Moore Voting Algorithm

        /*
         * 思路：
         * 这是一个完整的字符串查询算法，我还没完全理解
         * 具体到这道题，其解题思路是这样的：
         * 对于一个数组，任意一个元素，进行遍历，遇到同样元素+1，不同-1
         * 要符合题设要求，majority元素的最终计数值必然大于0，而其他的<0
         * 这样，从0位置开始遍历数组，
         * 按照上述规则计数，每次计数器归0就重新选择一个备选元素
         * （i.e. 舍弃之前的片段）
         * 最终能计数器不归0的那个元素，就是majority
         *
         * */

        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // Approach 2: HashMap 配套方法，用来计数
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                // 优化：HashMap的value可以直接运算
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    // Approach 4: Randomization 配套方法，用来确定随机范围
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
        // 后加上min才能保证获得的随机数在[min, max]范围内
    }

    // Approach 4: Randomization 配套方法，用来技术
    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // Approach 5: Divide and Conquer 配套方法，用来迭代、比较
    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case: the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    // Approach 5: Divide and Conquer 配套方法，用来计数
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
