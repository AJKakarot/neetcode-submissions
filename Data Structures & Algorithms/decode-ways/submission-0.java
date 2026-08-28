class Solution {
    int[] dp;

    int solve(String s, int i) {
        // Successfully decoded entire string
        if (i == s.length()) {
            return 1;
        }

        // Starts with 0 → invalid
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Take one digit
        int ways = solve(s, i + 1);

        // Take two digits
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));

            if (num >= 10 && num <= 26) {
                ways += solve(s, i + 2);
            }
        }

        return dp[i] = ways;
    }

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(s, 0);
    }
}