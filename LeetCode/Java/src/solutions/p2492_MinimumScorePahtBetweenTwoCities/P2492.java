package solutions.p2492_MinimumScorePahtBetweenTwoCities;

import java.util.LinkedList;
import java.util.Queue;

public class P2492 {
    public int minScore(int n, int[][] roads) {
        /*
         * Solution v1: Brute Force
         *
         * Memory Limit Exceeded
         */
        int ans = Integer.MAX_VALUE;

        int[][] path = new int[n + 1][n + 1];
        for (int[] road : roads) {
            path[road[0]][road[1]] = road[2];
            path[road[1]][road[0]] = road[2];
        }
        System.out.println(path);
        boolean[] visited = new boolean[n + 1];
        System.out.println(visited);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int s = queue.poll();
            for (int i = 0; i < n; i++) {
                if (path[s][i] > 0) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }

                ans = Math.min(ans, path[s][i]);
            }
        }

        return ans;
    }
}
