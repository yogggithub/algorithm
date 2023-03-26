package solutions.p2316_CountUnreachablePairsNodesUndirectedGraph;

import java.util.*;

public class P2316 {
    public long countPairs(int n, int[][] edges) {
        Stack<List<Integer>> graph = new Stack<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        int ans = n * (n - 1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int neighbors = 0;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    ++neighbors;
                    for (Integer j : graph.get(q.poll())) {
                        if (!visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
                ans -= neighbors * (neighbors - 1);
            }
        }

        return ans / 2;
    }
}
