class Solution {
    int start = 0;
    int maxLen = 1;
    Boolean[][] dp;

    boolean isPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        return dp[i][j] = isPalindrome(s, i + 1, j - 1);
    }

    void solve(String s, int i, int j) {
        if (i > j)
            return;

        if (isPalindrome(s, i, j)) {
            if (j - i + 1 > maxLen) {
                start = i;
                maxLen = j - i + 1;
            }
        }

        // only ONE recursive call
        solve(s, i + 1, j);
    }

    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];

        solve(s, 0, s.length() - 1);

        return s.substring(start, start + maxLen);
    }
}