package solutions.p2187_Minimum_Time_to_Complete_Trips;


import java.util.Arrays;

public class P2187 {
    public long minimumTime(int[] time, int totalTrips) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 206 ms @ (beats) 76.25%
         * Memory Usage: 51 MB @ (beats) 98.26%
         */

        long l = 1;
        long r = Arrays.stream(time).min().getAsInt() * (long) totalTrips;

        while (l < r) {
            long mid = (l + r) / 2;

            long sum = 0;

            for (int t : time) {
                sum += mid / t;
            }

            if (sum >= totalTrips) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
