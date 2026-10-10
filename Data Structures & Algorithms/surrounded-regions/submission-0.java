
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1: Check first and last column
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // Step 2: Check first and last row
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // Step 3: Capture surrounded regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;

        // Boundary check and safe-cell check
        if (r < 0 || r >= m ||
            c < 0 || c >= n ||
            board[r][c] != 'O') {
            return;
        }

        // Mark this O as safe
        board[r][c] = 'T';

        // Visit four directions
        dfs(board, r - 1, c); // Up
        dfs(board, r + 1, c); // Down
        dfs(board, r, c - 1); // Left
        dfs(board, r, c + 1); // Right
    }
}
