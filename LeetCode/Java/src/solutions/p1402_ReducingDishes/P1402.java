package solutions.p1402_ReducingDishes;

import java.util.Arrays;

public class P1402 {
    public int maxSatisfaction(int[] satisfaction) {
        /*
         * Solution v1: Greedy
         *
         * Runtime: 1 ms @ (beats) 100%
         * Memory Usage: 40.3 MB @ (beats) 91.75%
         */

        Arrays.sort(satisfaction);

        int ans = 0;
        int curr_sati = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            curr_sati += satisfaction[i];
            if (curr_sati < 0) {
                break;
            }
            ans += curr_sati;
        }
        return ans;
    }
}
