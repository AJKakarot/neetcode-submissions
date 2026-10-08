class Solution {

    int m;
    int n;

    public void islandsAndTreasure(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, int distance) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] == -1) {
            return;
        }

        // Current value is already better
        if (grid[i][j] < distance) {
            return;
        }

        grid[i][j] = distance;

        dfs(grid, i + 1, j, distance + 1);
        dfs(grid, i - 1, j, distance + 1);
        dfs(grid, i, j + 1, distance + 1);
        dfs(grid, i, j - 1, distance + 1);
    }
}