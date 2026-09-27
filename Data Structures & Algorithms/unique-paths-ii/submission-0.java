class Solution {
    Integer t[][] = new Integer[101][101];
    int m, n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        return solve(obstacleGrid, 0, 0);
    }
    int solve(int[][] obstacleGrid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || obstacleGrid[i][j] != 0) {
            return 0;
        }

        if (t[i][j] != null)
            return t[i][j];

        if (i == m - 1 && j == n - 1)
            return 1;

        // Why we are not making [i][j] visited ?
        // Because robot can only move down or right so it will never visit any visited cell again
        // int temp = obstacleGrid[i][j];
        // obstacleGrid[i][j] = -1;

        int right = solve(obstacleGrid, i, j + 1);
        int down = solve(obstacleGrid, i + 1, j);

        // obstacleGrid[i][j] = temp;

        return t[i][j] = right + down;
    }
}