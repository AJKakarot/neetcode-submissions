class Solution {

    private int solve(int i, int[] nums, int Xor) {
        if (i == nums.length) {
            return Xor;
        }

        int include = solve(i + 1, nums, nums[i] ^ Xor);
        int exclude = solve(i + 1, nums, Xor);

        return include + exclude;
    }

    public int subsetXORSum(int[] nums) {
        return solve(0, nums, 0);
    }
}

                //                  solve(0,0)
                //                /             \
                //        Include1               Exclude1
                //         solve(1,1)            solve(1,0)
                //        /        \            /        \
                // Include2     Exclude2   Include2   Exclude2
                // solve(2,3)  solve(2,1) solve(2,2) solve(2,0)
                //    |            |        |          |
                //  return3    return1    return2  return0
                //        \      /           \    /
                //         3+1=4             2+0=2
                //               \           /
                //                \         /
                //                 4 + 2 = 6



