class Solution {
    int m;
    int n;

    int dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        // Mark visited
        grid[i][j] = 0;

        int down = dfs(grid, i + 1, j);
        int up = dfs(grid, i - 1, j);
        int right = dfs(grid, i, j + 1);
        int left = dfs(grid, i, j - 1);

        return 1 + down + up + right + left;
    }

    public int maxAreaOfIsland(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int maxi = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    maxi = Math.max(maxi, area);
                }
            }
        }

        return maxi;
    }
}