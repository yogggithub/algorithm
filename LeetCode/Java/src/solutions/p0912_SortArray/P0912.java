package solutions.p0912_SortArray;

import java.util.Arrays;

public class P0912 {
    public static void main(String[] args) {

        P0912 s = new P0912();

        int[] nums = {5, 2, 3, 1};
        System.out.println(s.sortArray(nums).toString());

        nums = new int[]{5, 1, 1, 2, 0, 0};
        System.out.println(s.sortArray(nums).toString());

    }

    public int[] sortArray(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int mid = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        return mergeSort(this.sortArray(left), this.sortArray(right));
    }

    public static int[] mergeSort(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0;
        int l = 0;
        int r = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[i++] = left[l++];
            } else {
                result[i++] = right[r++];
            }
        }

        if (l < left.length) {
            while (l < left.length) {
                result[i++] = left[l++];
            }
        }

        if (r < right.length) {
            while (r < right.length) {
                result[i++] = right[r++];
            }
        }

        return result;

    }
}
