class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // A turbulent subarray is a contiguous subarray where the comparison between every pair of
        // adjacent elements alternates between > and <.

        int left = 0;
        int right = 1;
        int ans = 1;

        while (right < arr.length) {
            if (arr[right] == arr[right - 1]) {
                left = right;
            }

            else if (right == arr.length - 1
                || (arr[right] > arr[right - 1]) == (arr[right + 1] > arr[right])) {
                ans = Math.max(ans, right - left + 1);
                left = right;
            }

            right++;
        }

        return ans;
    }
}
