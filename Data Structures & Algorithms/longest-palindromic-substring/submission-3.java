class Solution {
    int start = 0;
    int maxLen = 1;

    Boolean[][] pal;
    Boolean[][] visited;

    boolean isPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;

        if (pal[i][j] != null)
            return pal[i][j];

        if (s.charAt(i) != s.charAt(j))
            return pal[i][j] = false;

        return pal[i][j] = isPalindrome(s, i + 1, j - 1);
    }

    void solve(String s, int i, int j) {
        if (i > j)
            return;

        // Already processed
        if (visited[i][j])
            return;

        visited[i][j] = true;

        if (isPalindrome(s, i, j)) {
            int len = j - i + 1;

            if (len > maxLen) {
                maxLen = len;
                start = i;
            }
        }

        solve(s, i, j - 1);
        solve(s, i + 1, j);
    }

    public String longestPalindrome(String s) {
        int n = s.length();

        pal = new Boolean[n][n];
        visited = new Boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        solve(s, 0, n - 1);

        return s.substring(start, start + maxLen);
    }
}