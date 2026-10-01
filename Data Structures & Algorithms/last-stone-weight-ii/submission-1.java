

public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;

        for (int stone : stones) {
            stoneSum += stone;
        }

        int target = (stoneSum + 1) / 2;

        int[][] memo = new int[stones.length + 1][target + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, stones, stoneSum, target, memo);
    }

    private int dfs(int i, int total, int[] stones,
                    int stoneSum, int target, int[][] memo) {

        if (total >= target || i == stones.length) {
            return Math.abs(total - (stoneSum - total));
        }

        if (memo[i][total] != -1) {
            return memo[i][total];
        }

        int skip = dfs(i + 1, total, stones,
                       stoneSum, target, memo);

        int take = dfs(i + 1, total + stones[i], stones,
                       stoneSum, target, memo);

        return memo[i][total] = Math.min(skip, take);
    }
}