class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;

        // Store minimum length
        int minLength = Integer.MAX_VALUE;

        // Expand window
        for (int right = 0; right < nums.length; right++) {

            // Add current element
            sum += nums[right];

            // Shrink while window is valid
            while (sum > target) {

                // Update minimum length
                minLength = Math.min(minLength,
                        right - left + 1);

                // Remove left element
                sum -= nums[left];

                // Move left pointer
                left++;
            }
               minLength = Math.min(minLength,
                        right - left + 1);
        }

   minLength = Math.min(minLength,
                        right - left + 1);

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}