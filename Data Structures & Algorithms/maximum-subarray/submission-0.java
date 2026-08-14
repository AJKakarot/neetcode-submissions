class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Decide:
            // New subarray start karein
            // Previous subarray continue karein
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Ab tak ka maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}