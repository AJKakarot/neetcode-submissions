class Solution {
    private void solve(int index, int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> result) {
        // Base Case
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Try every unused element
        for (int i = 0; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Skip if already used
            if (used[i]) {
                continue;
            }

            // Choose
            used[i] = true;
            temp.add(nums[i]);

            // Explore
            solve(nums, used, temp, result);

            // Backtrack (Undo)
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(0,nums, used, temp, result);

        return result;
    }
}
