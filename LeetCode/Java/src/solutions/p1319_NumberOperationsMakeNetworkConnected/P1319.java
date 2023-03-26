package solutions.p1319_NumberOperationsMakeNetworkConnected;

public class P1319 {
    public int makeConnected(int n, int[][] connections) {
        /*
         * Solution v1: DFS
         *
         * Runtime: 3 ms @ (beats) 99.51%
         * Memory Usage: 60.1 MB @ (beats) 61.10%
         */
        if (connections.length < n - 1) {
            return -1;
        }

        int[] network = new int[n];
        for (int i = 0; i < n; i++) {
            network[i] = i;
        }

        int ans = n;
        for (int[] p : connections) {
            int root_x = find_root(network, p[0]);
            int root_y = find_root(network, p[1]);

            if (root_x != root_y) {
                network[root_x] = root_y;
                ans--;
            }
        }

        return  ans - 1;

    }

    public static int find_root(int[] network, int node) {
        while (network[node] != node) {
            network[node] = network[network[node]];
            node = network[node];
        }
        return node;

    }
}
