class Solution {
    int[][] t = new int[501][501];

    public int solve(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return m + n;

        if (t[m][n] != -1)
            return t[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return t[m][n] = solve(s1, s2, m - 1, n - 1);
        else {
            int insertC = 1 + solve(s1, s2, m, n - 1);
            int deleteC = 1 + solve(s1, s2, m - 1, n);
            int replaceC = 1 + solve(s1, s2, m - 1, n - 1);

            return t[m][n] = Math.min(Math.min(insertC, deleteC), replaceC);
        }
    }

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        for (int[] row : t) Arrays.fill(row, -1);

        return solve(s1, s2, m, n);
    }
}