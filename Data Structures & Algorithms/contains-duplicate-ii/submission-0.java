class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Check if current element already exists
            if (set.contains(nums[right])) {
                return true;
            }

            // Add current element to window
            set.add(nums[right]);

            // Keep window size at most k
            if (right - left >= k) {
                set.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}