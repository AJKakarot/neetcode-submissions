class Solution {
    Boolean[] dp;

    boolean solve(String s, int i, Set<String> set) {
        // Entire string successfully broken
        if (i == s.length()) {
            return true;
        }

        // Already calculated
        if (dp[i] != null) {
            return dp[i];
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);

            if (set.contains(word)) {
                if (solve(s, j, set)) {
                    return dp[i] = true;
                }
            }
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        dp = new Boolean[s.length()];

        return solve(s, 0, set);
    }
}