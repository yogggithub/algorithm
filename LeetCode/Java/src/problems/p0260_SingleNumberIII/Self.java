package problems.p0260_SingleNumberIII;

public class Self {
    public int[] singleNumber(int[] nums) {
        /*
         * Solution v1: Brute Force with Set
         *
         * Runtime: 3 ms @ (beats) 37.25%
         * Memory Usage: 39.5 MB @ (beats) 60.14%
         */
        // Set<Integer> isUnique = new HashSet<>();
        //
        // for (int num : nums) {
        //     if (!isUnique.add(num)) {
        //         isUnique.remove(num);
        //     }
        // }
        // int[] result = new int[2];
        // int i = 0;
        // for (Integer num : isUnique) {
        //     result[i++] = num;
        // }
        // return result;

        /*
         * Solution v2: Sort first
         *
         * Runtime: 3 ms @ (beats) 37.25%
         * Memory Usage: 39.5 MB @ (beats) 60.14%
         */
        // Arrays.sort(nums);
        // int[] result = new int[2];
        // int index = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     // corner case
        //     if (i == nums.length - 1) {
        //         result[1] = nums[i];
        //         break;
        //     } else if (nums[i] == nums[i + 1]) {
        //         // move loop index one step
        //         // and the loop itself would move another step
        //         // so actually two steps each loop
        //         i++;
        //     } else {
        //         result[index] = nums[i];
        //         index++;
        //     }
        // }
        // return result;

        /*
         * (learn from Internet)
         * Solution v3: XOR
         */
        int bitmask = 0;
        for (int num : nums) {
            bitmask = bitmask ^ num;
        }
        int diff = bitmask & (~bitmask + 1);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                x = x ^ num;
            }
        }
        return new int[]{x, x ^ bitmask};
    }
}
