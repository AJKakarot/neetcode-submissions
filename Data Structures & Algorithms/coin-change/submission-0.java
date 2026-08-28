class Solution {
    int[] dp;

    int solve(int[] coins, int amount) {
        // Exact amount achieved
        if (amount == 0) {
            return 0;
        }

        // Impossible
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = solve(coins, amount - coin);

            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + result);
            }
        }

        return dp[amount] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = solve(coins, amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}