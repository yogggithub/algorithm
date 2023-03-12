package solutions.p0011_ContainerWithMostWater;

public class P0011 {
    public int maxArea(int[] height) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 3 ms @ (beats) 92.95%
         * Memory Usage: 52.4 MB @ (beats) 71%
         */

        // int ans = 0;
        //
        // int l = 0;
        // int r = height.length - 1;
        //
        // while (l < r) {
        //     int w = r - l;
        //     int h = 0;
        //
        //     if (height[l] < height[r]) {
        //         h = height[l++];
        //     } else {
        //         h = height[r--];
        //     }
        //     ans = Math.max(ans, h * w);
        // }
        //
        // return ans;

        /*
         * Solution v1.1: Performance enhance
         *
         * Runtime: 2 ms @ (beats) 99%
         * Memory Usage: 53.1 MB @ (beats) 16.69%
         */
        int ans = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            ans = Math.max(ans, h * (r - l));

            while (height[l] <= h && l < r) {
                l++;
                System.out.println("l: " + l);
            }
            while (height[r] <= h && l < r) {
                r--;
                System.out.println("r: " + r);
            }
        }

        return ans;
    }
}
