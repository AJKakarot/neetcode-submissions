class Solution {
    public int solve(int i, int j, int m, int n, int[][] t) {
        // Base case: Reached the bottom-right cell
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        // If already computed, return the stored result
        if (t[i][j] != -1) {
            return t[i][j];
        }

        // Calculate the number of paths by going right and down
        int right = solve(i, j + 1, m, n, t);
        int down = solve(i + 1, j, m, n, t);

        // Store the result in the memoization table
        return t[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {
        // Create a memoization table initialized with -1
        int[][] t = new int[m][n];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        // Start the recursive computation from the top-left cell
        return solve(0, 0, m, n, t);
    }
}
