class Solution {
    // Check whether queen can be placed or not
    private boolean isSafe(int row, int col, List<String> board, int n) {
        // Check Same Column
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Check Upper Left Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Check Upper Right Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void solve(int row, List<String> board, List<List<String>> result, int n) {
        // Base Case
        // All queens are placed
        if (row == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {
            // Check if current position is safe
            if (isSafe(row, col, board, n)) {
                // Choose
                char[] currentRow = board.get(row).toCharArray();
                currentRow[col] = 'Q';
                board.set(row, new String(currentRow));

                // Explore
                solve(row + 1, board, result, n);

                // Backtrack (Undo)
                currentRow = board.get(row).toCharArray();
                currentRow[col] = '.';
                board.set(row, new String(currentRow));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        List<String> board = new ArrayList<>();

        // Create Empty Board
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append('.');
            }

            board.add(sb.toString());
        }

        solve(0, board, result, n);

        return result;
    }
}

// Take/Skip → 2ⁿ
// Permutations → n!
// K choices at every level → kⁿ
// Grid DFS → (Rows × Cols) × (4^Depth)
// One queen per row → N!
