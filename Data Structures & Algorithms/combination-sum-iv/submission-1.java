class Solution {
    int n;
    int[] t = new int[2001];

    int solve(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }

        if (t[target] != -1) {
            return t[target];
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int take_i = solve(nums, target - nums[i]);

            result += take_i;
        }

        return t[target] = result;
    }

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;

        Arrays.fill(t, -1);

        return solve(nums, target);
    }
}