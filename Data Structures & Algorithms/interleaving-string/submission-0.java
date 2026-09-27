class Solution {
    int m, n, N;
    int[][][] t;

    boolean solve(int i, int j, int k, String s1, String s2, String s3) {
        if (i == m && j == n && k == N) {
            return true;
        }

        if (k >= N) {
            return false;
        }

        if (t[i][j][k] != -1) {
            return t[i][j][k] == 1;
        }

        boolean result = false;

        // Take character from s1
        if (i < m && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, k + 1, s1, s2, s3);
        }

        if (result) {
            t[i][j][k] = 1;
            return true;
        }

        // Take character from s2
        if (j < n && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, k + 1, s1, s2, s3);
        }

        t[i][j][k] = result ? 1 : 0;
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();

        t = new int[m + 1][n + 1][N + 1];

        // Equivalent to memset(t, -1, sizeof(t))
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                java.util.Arrays.fill(t[i][j], -1);
            }
        }

        return solve(0, 0, 0, s1, s2, s3);
    }
}