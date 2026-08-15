
        // A turbulent subarray is a contiguous subarray where the comparison between every pair of
        // adjacent elements alternates between > and <.

     class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int left = 0;
        int ans = 1;

        for (int right = 1; right < arr.length; right++) {

            if (arr[right] == arr[right - 1]) {
                left = right;
            }
            else if (right == arr.length - 1 ||
                     (arr[right] - arr[right - 1] > 0) ==
                     (arr[right + 1] - arr[right] > 0)) {

                ans = Math.max(ans, right - left + 1);
                left = right;
            }
        }

        return ans;
    }
}