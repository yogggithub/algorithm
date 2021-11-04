package problems.p0053_MaximumSubarray;

public class solution {
    public static void main(String[] args) {
        solution self = new solution();
        int[] num1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] num2 = new int[]{1};
        int[] num3 = new int[]{-1, -2};

        System.out.println(self.maxSubArray(num1));
        System.out.println(self.maxSubArray(num2));
        System.out.println(self.maxSubArray(num3));

    }

    public int maxSubArray(int[] nums) {
        // 实际只用一个for即可
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum < 0){
                sum = nums[i];
            } else{
                sum += nums[i];
            }

            if (max < sum){
                max = sum;
            }
        }

        return max;
    }

}
