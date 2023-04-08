package solutions.p1020_NumberofEnclaves;

public class P1020 {
    public int numEnclaves(int[][] grid) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 7 ms @ (beats) 97.85%
         * Memory Usage: 54.2 MB @ (beats) 72.45%
         */
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < this.m; i++) {
            this.marker(i, 0);
            this.marker(i, this.n - 1);
        }

        for (int j = 0; j < this.m; j++) {
            this.marker(0, j);
            this.marker(this.m - 1, j);
        }

        int ans = 0;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 1) {
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
        if (x < 0 || x >= this.m || y < 0 || y >= this.n || this.grid[x][y] == 0) {
            return;
        } else {
            grid[x][y] = 0;
        }

        this.marker(x - 1, y);
        this.marker(x + 1, y);
        this.marker(x, y - 1);
        this.marker(x, y + 1);
    }
}
