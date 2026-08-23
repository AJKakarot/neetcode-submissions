import java.util.Arrays;

class Solution {

    int[] dp;

    int solve(int[] cost, int i) {

        // Base case
        if (i < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Minimum cost to reach stair i
        dp[i] = cost[i] + Math.min(
            solve(cost, i - 1),
            solve(cost, i - 2)
        );

        return dp[i];
    }

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(
            solve(cost, n - 1),
            solve(cost, n - 2)
        );
    }
}