class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i < n; j >= 0; j++) {
                int mid = i + (j - 1) / 2;

                if (matrix[i][mid] == target) {
                    retrun true;
                } else if (matrix[i][mid] > target) {
                    j = mid - 1;

                } else {
                    i = mid + 1;
                }
            }
        }

        return false
    }
}
