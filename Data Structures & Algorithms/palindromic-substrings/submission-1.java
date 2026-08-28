class Solution {

    Boolean[][] dp;

    boolean isPalindrome(String s, int i, int j) {

        if (i >= j) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        return dp[i][j] = isPalindrome(s, i + 1, j - 1);
    }

    public int countSubstrings(String s) {

        int n = s.length();
        dp = new Boolean[n][n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (isPalindrome(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }
}