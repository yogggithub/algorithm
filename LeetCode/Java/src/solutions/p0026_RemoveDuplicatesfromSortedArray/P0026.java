package solutions.p0026_RemoveDuplicatesfromSortedArray;

public class P0026 {
    public int removeDuplicates(int[] nums) {
        int k = 0; // unique element amount
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[k++] = nums[i];
            } else if (nums[k - 1] < nums[i]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
