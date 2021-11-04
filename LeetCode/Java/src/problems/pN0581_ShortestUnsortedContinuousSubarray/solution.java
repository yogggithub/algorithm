package problems.pN0581_ShortestUnsortedContinuousSubarray;

public class solution {
    public static void main(String[] args) {
        solution self = new solution();
        int[] nums1 = new int[]{2, 6, 4, 8, 10, 9, 15};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{1, 3, 2, 4};
        int[] nums4 = new int[]{1};
        int[] nums5 = new int[]{1, 2};
        int[] nums6 = new int[]{1, 3, 2, 2, 2};
        System.out.println(self.findUnsortedSubarray(nums1));
        // System.out.println(self.findUnsortedSubarray(nums2));
        // System.out.println(self.findUnsortedSubarray(nums3));
        // System.out.println(self.findUnsortedSubarray(nums4));
        // System.out.println(self.findUnsortedSubarray(nums5));
        // System.out.println(self.findUnsortedSubarray(nums6));
    }

    public int findUnsortedSubarray(int[] nums) {

        // Approach 1: Brute Force
        /*
         * In the brute force approach, we consider every possible subarray
         * that can be formed from the given array nums.
         * For every subarray nums[i:j] considered,
         * we need to check whether this is the smallest unsorted subarray
         * or not. Thus, for every such subarray considered,
         * we find out the maximum and minimum values lying in
         * that subarray given by max and min respectively.
         *
         * If the subarrays nums[0:i-1] and nums[j:n-1]
         * are correctly sorted, then only nums[i:j] could be
         * the required subrray. Further, the elements in nums[0:i-1]
         * all need to be lesser than the minmin for satisfying
         * the required condition. Similarly, all the elements
         * in nums[j:n-1] need to be larger than max.
         * We check for these conditions for every possible i and j selected.
         *
         * Further, we also need to check if nums[0:i-1] and nums[j:n-1]
         * are sorted correctly. If all the above conditions are satisfied,
         * we determine the length of the unsorted subarray as j-i.
         * We do the same process for every subarray chosen and determine
         * the length of the smallest unsorted subarray found.
         *
         * 思路：条件判断很复杂
         * 1. 遍历数组，从当前元素往后的每个元素都要当作是可能结果来考虑
         * 2. 若[0, i]和[j, n]是升序的，则[i+1, j-1]是想找的子数组，注意指针位置
         * 3. 在找子数组[i+1, j-1]，对[0, i]和[j, n]都需判断是否是顺序排序
         *
         * */

        // int res = nums.length;
        // for (int i = 0; i < nums.length; i++) {
        //     // 当前元素往后的每个元素，所形成的子数组，都需要检查
        //     for (int j = i; j <= nums.length; j++) {
        //         // 每个[i, j]的子数组，其最大、最小、升序判断标识都会重置
        //         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE,
        //                 prev = Integer.MIN_VALUE;
        //         // 对[i, j]这个子数组，找出其中的最大、最小值，来判断是否升序
        //         for (int k = i; k < j; k++) {
        //             min = Math.min(min, nums[k]);
        //             max = Math.max(max, nums[k]);
        //         }
        //         // 当符合时，跳出循环，进入j的下个循环
        //         // （不是首个元素且子数组之前的那个元素大于子数组最小值）
        //         // 或（不是最末元素且子数组末位元素小于子数组最大值）
        //         if ((i > 0 && nums[i - 1] > min)
        //                 || (j < nums.length && nums[j] < max)){
        //             continue;
        //         }
        //         int k = 0;
        //         // 判断子数组前的部分[0, i]，是否升序
        //         while (k < i && prev <= nums[k]) {
        //             prev = nums[k];
        //             k++;
        //         }
        //         // k != i时，跳出循环，进入j的下个循环
        //         if (k != i){
        //             continue;
        //         }
        //         k = j;
        //         // 判断子数组后的部分[j, n]，是否升序
        //         while (k < nums.length && prev <= nums[k]) {
        //             prev = nums[k];
        //             k++;
        //         }
        //         //
        //         if (k == nums.length) {
        //             res = Math.min(res, j - i);
        //         }
        //     }
        // }
        // return res;


        // Approach 2: Better Brute Force
        /*
         * 思路：
         * 1. 遍历数组，把当前元素与后面每个元素比较，检查是否升序
         *    如果当前比后面元素小，则说明这两个元素都错了
         * 2. 记录下这两个错误元素各自的位置
         * 3. 循环重复这个过程，将错误元素位置不断向左（前）向右（后）
         *    延伸，最终得到子数组的边界
         * 4. 利用子数组边界，相减求出元素个数
         *
         * */

        // int l = nums.length, r = 0;
        // // traverse array
        // for (int i = 0; i < nums.length - 1; i++) {
        //     // compare every element with elements backward
        //     for (int j = i + 1; j < nums.length; j++) {
        //         // when element is greater than backward
        //         // means that the two elements are at wrong position
        //         if (nums[j] < nums[i]) {
        //             // right boarder, maximum
        //             r = Math.max(r, j);
        //             // left boarder, minimum
        //             l = Math.min(l, i);
        //         }
        //     }
        // }
        // return r - l < 0 ? 0 : r - l + 1;


        // Approach 3: Using Sorting
        /*
         * 思路：
         * 1. 复制数组（学会并运用），排序这个复制品
         * 2. traverse 两个数组，同样位置元素不相等，说明位置不对
         * 3. 通过最大最小方式，扩展和记录子数组的边界
         *
         * 这个思路是一开始想的，但因为对象引用、重复值的问题，没
         * 仔细考虑就给放弃了。
         *
         * */

        // int[] snums = nums.clone();
        // Arrays.sort(snums);
        // int start = snums.length, end = 0;
        // for (int i = 0; i < snums.length; i++) {
        //     if (snums[i] != nums[i]) {
        //         start = Math.min(start, i);
        //         end = Math.max(end, i);
        //     }
        // }
        // return (end - start >= 0 ? end - start + 1 : 0);


        // Approach 4: Using Stack
        /*
         * 思路：用stack存放指针位置，然后元素比较，来寻找合适位置
         * 1. 遍历数组，将每个指针位置存进stack中
         * 2. 若stack顶端所指向的元素（靠前的元素），比当前元素小
         *    则顶端指针是备选左边界，并从stack中踢出
         *    （不踢出的话，已经遍历过的数组元素就不会被再次选到，
         *    无法应对后面元素比前面元素还小的情况）
         * 3.清空stack，第二遍遍历，寻找右边界
         *
         * */

        // Stack<Integer> stack = new Stack<Integer>();
        // int l = nums.length, r = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     while (!stack.isEmpty() &&
        //             nums[stack.peek()] > nums[i]){
        //         l = Math.min(l, stack.pop());
        //     }
        //     stack.push(i);
        // }
        // stack.clear();
        // for (int i = nums.length - 1; i >= 0; i--) {
        //     while (!stack.isEmpty()
        //             && nums[stack.peek()] < nums[i]){
        //         r = Math.max(r, stack.pop());
        //     }
        //     stack.push(i);
        // }
        // return r - l > 0 ? r - l + 1 : 0;


        // Approach 5: Without Using Extra Space
        /*
         * 思路：这个算法很奇怪
         * 1. 寻找最大值和最小值。这里比较难理解：
         *    最小值，是在当前元素小于前个元素时，记录元素
         *         然后比较这些被记录的元素，找到其中的最小值
         *    最大值，则反向遍历，当前元素小于后个元素
         * 2. 为上步的两个最值，找到原数组中合适的插入位置
         *    这两个插入位置，就是子数组的边界
         * 3. 在第一次过程中，就已经确保子数组前后部分是升序的了
         *
         * */

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]){
                flag = true;
            }
            if (flag){
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]){
                flag = true;
            }
            if (flag){
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]){
                break;
            }
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r]){
                break;
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
