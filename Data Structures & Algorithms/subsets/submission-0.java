class Solution {

    private void solve(int[] nums, int i,
                       List<Integer> temp,
                       List<List<Integer>> result) {

        if (i == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Include
        temp.add(nums[i]);
        solve(nums, i + 1, temp, result);

        // Backtrack
        temp.remove(temp.size() - 1);

        // Exclude
        solve(nums, i + 1, temp, result);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(nums, 0, temp, result);

        return result;
    }
}