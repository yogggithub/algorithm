package solutions.p2405_OptimalPartitionString;

import java.util.Arrays;

public class P2405 {
    public int partitionString(String s) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 8 ms @ (beats) 95.45%
         * Memory Usage: 42.6 MB @ (beats) 96.17%
         */
        int ans = 1;

        int[] last_seen = new int[26];
        Arrays.fill(last_seen, -1);
        int last = 0;

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            int prev = last_seen[temp];

            if (prev >= last) {
                ans++;
                last = i;
            }
            last_seen[temp] = i;

        }
        return ans;

    }
}
