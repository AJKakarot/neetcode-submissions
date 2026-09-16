class Solution {
    int n;
    int[][] t = new int[2501][2501];

    int solve(int[] nums, int i, int p) {
        if (i >= n) {
            return 0;
        }

        if (t[i][p + 1] != -1) {
            return t[i][p + 1];
        }

        int take = 0;

        if (p == -1 || nums[i] > nums[p]) {
            take = 1 + solve(nums, i + 1, i);
        }

        int skip = solve(nums, i + 1, p);

        return t[i][p + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        n = nums.length;

        for (int i = 0; i < t.length; i++) {
            java.util.Arrays.fill(t[i], -1);
        }

        return solve(nums, 0, -1);
    }
}