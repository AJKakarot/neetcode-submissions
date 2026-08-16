class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // Current index tak pahunch hi nahi sakte
            if (i > maxReach) {
                return false;
            }

            // Maximum reachable index update karo
            maxReach = Math.max(maxReach, i + nums[i]);

            // Last index tak pahunch gaye
            // if (maxReach >= nums.length - 1) {
            //     return true;
            // }
        }

        return true;
    }
}