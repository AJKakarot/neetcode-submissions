class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Minimum is in the right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            // Minimum is at mid or in the left half
            else {
                high = mid;
            }
        }

        return nums[low];
    }
}