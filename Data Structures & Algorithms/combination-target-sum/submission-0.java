class Solution {

    private void solve(int[] candidates,
                       int target,
                       int index,
                       List<Integer> temp,
                       List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || index == candidates.length)
            return;

        // Include
        temp.add(candidates[index]);
        solve(candidates,
              target - candidates[index],
              index,
              temp,
              result);

        temp.remove(temp.size() - 1);

        // Exclude
        solve(candidates,
              target,
              index + 1,
              temp,
              result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(candidates,
              target,
              0,
              temp,
              result);

        return result;
    }
}