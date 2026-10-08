class Solution {
int m;
    int n;

    void dfs(int[][] grid, int i, int j,int count) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = -1; // mark visited

        if(grid[i][j] == 1){

          count++;

         }
        dfs(grid, i + 1, j,count);
        dfs(grid, i - 1, j,count);
        dfs(grid, i, j + 1,count);
        dfs(grid, i, j - 1,count);



       maxi =  Math.max(maxi,count);
       return maxi;
    }

    public int maxAreaOfIsland(int[][] grid) {
         m = grid.length;
        n = grid[0].length;
        peri = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = 1;
                  int ans =   dfs(grid, i, j,count);
                    return ans;
                }
            }
        }

        return -1;
    }
}

    
   