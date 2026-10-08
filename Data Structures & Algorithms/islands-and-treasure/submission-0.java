class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Put ALL treasure cells into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int[][] directions = {
            {1, 0}, // down
            {-1, 0}, // up
            {0, 1}, // right
            {0, -1} // left
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int i = current[0];
            int j = current[1];

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                // Boundary check
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                    continue;
                }

                // Water
                if (grid[ni][nj] == -1) {
                    continue;
                }

                // Already visited
                if (grid[ni][nj] != Integer.MAX_VALUE) {
                    continue;
                }

                // Distance = current distance + 1
                grid[ni][nj] = grid[i][j] + 1;

                queue.offer(new int[] {ni, nj});
            }
        }
    }
}