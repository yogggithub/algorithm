package solutions.p0881_BoatsSavePeople;

import java.util.Arrays;

public class P0881 {
    public int numRescueBoats(int[] people, int limit) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 18 ms @ (beats) 50.89%
         * Memory Usage: 50.2 MB @ (beats) 92.48%
         */

        Arrays.sort(people);

        int ans = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right--] <= limit) {
                left++;
            }
            ans++;
        }
        return ans;

    }
}
