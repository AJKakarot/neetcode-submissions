class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft, topRight, bottomLeft, bottomRight;

    public Node() {}

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }
}

class Solution {

    // Check if all values in subgrid are same
    public boolean isAllSame(int[][] grid, int x, int y, int n) {
        int val = grid[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != val)
                    return false;
            }
        }
        return true;
    }

    public Node solve(int[][] grid, int x, int y, int n) {
        if (isAllSame(grid, x, y, n)) {
            return new Node(grid[x][y] == 1, true);
        }

        Node root = new Node(true, false);

        int half = n / 2;

        root.topLeft = solve(grid, x, y, half);
        root.topRight = solve(grid, x, y + half, half);
        root.bottomLeft = solve(grid, x + half, y, half);
        root.bottomRight = solve(grid, x + half, y + half, half);

        return root;
    }

    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }
}