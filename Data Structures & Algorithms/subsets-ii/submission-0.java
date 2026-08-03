class Solution {

    private void solve(int index,
                       int[] nums,
                       List<Integer> temp,
                       List<List<Integer>> result) {

        // Har state ek valid subset hai
        result.add(new ArrayList<>(temp));

        // Current index se saare elements try karo
        for (int i = index; i < nums.length; i++) {

            // Duplicate skip
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            temp.add(nums[i]);

            // Explore
            solve(i + 1, nums, temp, result);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Duplicate ek saath lane ke liye
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(0, nums, temp, result);

        return result;
    }
}