package algorithm.floodfill;

class self {

    public static void main(String[] args) {
        int[][] input = {
                {1, 4, 4, 4, 4, 3, 3, 1},
                {2, 1, 1, 4, 3, 3, 1, 1},
                {3, 2, 1, 1, 2, 3, 2, 1},
                {3, 3, 2, 1, 2, 2, 2, 2},
                {3, 1, 3, 1, 1, 4, 4, 4},
                {1, 1, 3, 1, 1, 4, 4, 4}
        };

        computeLargestConnectedGrid(input);
    }

    static final int n = 6;
    static final int m = 8;

    // stores information about which cell
    // are already visited in a particular BFS
    static final int[][] visited = new int[n][m];

    // result stores the final result grid
    static final int[][] result = new int[n][m];

    // stores the count of cells
    // in the largest connected component
    static int COUNT;

    public static void computeLargestConnectedGrid(int[][] input) {
        // 当前最大子块节点数
        int currentMax = Integer.MIN_VALUE;

        // 遍历input，查找最大子块
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 重置访问过
                resetVisited();
                // 初始化计数
                COUNT = 0;

                /*
                 * 由于方块遍历是向右向下进行
                 * 左侧和上侧的节点就无需再次检查
                 * 所以只需要两个方向推进：右、下
                 */
                if (j + 1 < m) {
                    BFS(input[i][j], input[i][j + 1],
                            i, j, input);
                }
                // 发现更大则刷新结果
                if (COUNT > currentMax) {
                    currentMax = COUNT;
                    restoreResult(input[i][j], input);
                }

                if (i + 1 < n) {
                    BFS(input[i][j], input[i + 1][j],
                            i, j, input);
                }
                // 发现更大则刷新结果
                if (COUNT > currentMax) {
                    currentMax = COUNT;
                    restoreResult(input[i][j], input);
                }
            }
        }
        display(result);
    }

    private static void resetVisited() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                visited[i][j] = 0;
    }

    private static void BFS(int x, int y,
                            int i, int j,
                            int[][] input) {
        /*
         * x, y移动一位，可以分别组成4对
         * 用数组表示，方便使用指针调用
         */
        int[] x_move = {0, 0, 1, -1};
        int[] y_move = {1, -1, 0, 0};


    }

    private static void restoreResult(int key, int[][] input) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 1 &&
                        input[i][j] == key)
                    result[i][j] = visited[i][j];
                else {
                    result[i][j] = 0;
                }
            }
        }
    }

    private static void display(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(
                        result[i][j] == 1 ?
                                result[i][j] + " " : ". ");
            }
            System.out.println();
        }
    }
}
