class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // These flags store whether the first row/column
        // originally contained a zero
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first column separately
        // because we will use it as a marker later
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        // Check first row separately
        // because we will use it as a marker later
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // Use first column and first row as markers
        // If matrix[i][j] is 0:
        //    matrix[i][0] = 0  -> mark entire row
        //    matrix[0][j] = 0  -> mark entire column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Now use the markers to make corresponding
        // rows and columns zero
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // If row marker OR column marker is zero,
                // current cell should also become zero
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Finally, handle the first row
        // only if it originally contained zero
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Finally, handle the first column
        // only if it originally contained zero
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}