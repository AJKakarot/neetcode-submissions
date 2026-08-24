

class Solution {
    public int solve(int[] nums, int i, int[] dp) {
        // Base case
        if (i >= nums.length) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Take
        int take = nums[i] + solve(nums, i + 2, dp);

        // Skip
        int skip = solve(nums, i + 1, dp);

        // Store answer
        dp[i] = Math.max(take, skip);

        return dp[i];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);
    }
}