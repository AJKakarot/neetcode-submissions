class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;        // Number of rows
        int n = matrix[0].length;     // Number of columns

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D index
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}