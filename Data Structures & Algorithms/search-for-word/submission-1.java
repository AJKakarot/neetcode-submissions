class Solution {

    // Directions: Right, Left, Down, Up
    int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    int rows, cols, len;

    private boolean dfs(char[][] board,
                        String word,
                        int row,
                        int col,
                        int index) {

        // Base Case
        // Word completely found
        if (index == len) {
            return true;
        }

        // Invalid Cases
        // 1. Out of Boundary
        // 2. Character does not match
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        // Choose

        // Save current character
        char temp = board[row][col];

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore
        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (dfs(board,
                    word,
                    newRow,
                    newCol,
                    index + 1)) {

                return true;
            }
        }

        // Backtrack (Undo)

        // Restore original character
        board[row][col] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;
        len = word.length();

        // Try every cell as starting point
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                // First character matches
                if (board[row][col] == word.charAt(0)) {

                    if (dfs(board,
                            word,
                            row,
                            col,
                            0)) {

                        return true;
                    }
                }
            }
        }

        return false;
    }
}