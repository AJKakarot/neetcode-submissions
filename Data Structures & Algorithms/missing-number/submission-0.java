class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        int ans = n;

        // XOR all indexes and all numbers
        for (int i = 0; i < n; i++) {

            ans = ans ^ i ^ nums[i];
        }

        return ans;
    }
}