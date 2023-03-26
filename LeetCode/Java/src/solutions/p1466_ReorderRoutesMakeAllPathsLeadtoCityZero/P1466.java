package solutions.p1466_ReorderRoutesMakeAllPathsLeadtoCityZero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1466 {
    public int minReorder(int n, int[][] connections) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 72 ms @ (beats) 62.64%
         * Memory Usage: 69.7 MB @ (beats) 63.89%
         */
        Map<Integer, List<Integer>> roads = new HashMap<>();
        for (int i = 0; i < n; i++) {
            roads.put(i, new ArrayList<>());
        }

        for (int[] c : connections) {
            roads.get(c[0]).add(c[1]);
            roads.get(c[1]).add(-c[0]);
        }



        return helper(n, 0, roads, new boolean[n]);
    }

    public static int helper(int n, int city, Map<Integer, List<Integer>> roads, boolean[] visited) {
        int ans = 0;

        visited[city] = true;

        for (Integer dest : roads.get(city)) {
            if (!visited[Math.abs(dest)]) {
                if (dest > 0){
                    ans++;
                }
                ans += helper(n, Math.abs(dest), roads, visited);
            }
        }
        return ans;
    }
}
