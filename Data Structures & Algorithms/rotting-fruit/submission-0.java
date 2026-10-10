class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: Add all rotten fruits to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Step 2: Four directions
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int minutes = 0;

        // Step 3: BFS
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] current = q.poll();

                int i = current[0];
                int j = current[1];

                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < m &&
                        nj >= 0 && nj < n &&
                        grid[ni][nj] == 1) {

                        grid[ni][nj] = 2;
                        fresh--;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
