class Solution {
    // Check whether queen can be placed or not
    private boolean isSafe(int row, int col, List<String> board, int n) {
        // Check Upper Column
        int r = row;
        while (r >= 0) {
            if (board.get(r).charAt(col) == 'Q')
                return false;

            r--;
        }

        // Check Upper Left Diagonal
        r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;

            r--;
            c--;
        }

        // Check Upper Right Diagonal
        r = row;
        c = col;

        while (r >= 0 && c < n) {
            if (board.get(r).charAt(c) == 'Q')
                return false;

            r--;
            c++;
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