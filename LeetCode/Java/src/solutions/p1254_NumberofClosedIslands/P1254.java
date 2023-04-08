package solutions.p1254_NumberofClosedIslands;

public class P1254 {
    public int closedIsland(int[][] grid) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 12 ms @ (beats) 5.18%
         * Memory Usage: 42.9 MB @ (beats) 61.71%
         */

        // int m = grid.length;
        // int n = grid[0].length;
        //
        // boolean[][] visited = new boolean[m][n];
        // int ans = 0;
        //
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (visited[i][j] || grid[i][j] == 1) {
        //             continue;
        //         }
        //
        //         visited[i][j] = true;
        //
        //         int island = 1;
        //
        //         Stack<int[]> stack = new Stack<>();
        //         stack.add(new int[]{i, j});
        //         while (!stack.isEmpty()) {
        //             int[] curr = stack.pop();
        //
        //             int r = curr[0];
        //             int c = curr[1];
        //
        //             int[][] neighbor =
        //                     {{r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};
        //
        //             for (int[] adj : neighbor) {
        //                 int x = adj[0];
        //                 int y = adj[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n) {
        //                     island = 0;
        //                     continue;
        //                 }
        //                 if (visited[x][y] || grid[x][y] == 1) {
        //                     continue;
        //                 }
        //                 visited[x][y] = true;
        //                 stack.add(new int[]{x, y});
        //             }
        //
        //         }
        //         ans += island;
        //     }
        // }
        // return ans;

        /*
         * Solution v2: BFS
         *
         * Runtime: 1 ms @ (beats) 100%
         * Memory Usage: 43.1 MB @ (beats) 34.8%
         */
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < this.m; i++) {
            this.marker(i, 0);
            this.marker(i, this.n - 1);
        }

        for (int j = 0; j < n; j++) {
            this.marker(0, j);
            this.marker(this.m - 1, j);
        }

        int ans = 0;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 0) {
                    this.marker(i,j);
                    ans++;
                }
            }
        }
        return ans;

    }

    int[][] grid;
    int m;
    int n;

    public void marker(int x, int y) {
        if (x < 0 || x >= this.m || y < 0 || y >= this.n || grid[x][y] == 1) {
            return;
        } else {
            grid[x][y] = 1;
        }

        this.marker(x - 1, y);
        this.marker(x + 1, y);
        this.marker(x, y - 1);
        this.marker(x, y + 1);

    }
}
