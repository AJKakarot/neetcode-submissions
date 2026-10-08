class Solution {

    int m;
    int n;
    int INF = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == INF) {

                    boolean[][] visited = new boolean[m][n];

                    int distance = dfs(grid, i, j, visited);

                    grid[i][j] = distance;
                }
            }
        }
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {

        // Out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return INF;
        }

        // Water
        if (grid[i][j] == -1) {
            return INF;
        }

        // Treasure
        if (grid[i][j] == 0) {
            return 0;
        }

        // Already visited in current path
        if (visited[i][j]) {
            return INF;
        }

        // Mark visited
        visited[i][j] = true;

        int down = dfs(grid, i + 1, j, visited);
        int up = dfs(grid, i - 1, j, visited);
        int right = dfs(grid, i, j + 1, visited);
        int left = dfs(grid, i, j - 1, visited);

        // Backtrack
        visited[i][j] = false;

        return 1 + Math.min(
            Math.min(down, up),
            Math.min(right, left)
        );
    }
}