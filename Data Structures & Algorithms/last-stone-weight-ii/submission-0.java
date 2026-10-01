public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }
        int target = (stoneSum + 1) / 2;

        return dfs(0, 0, stones, stoneSum, target);
    }

    private int dfs(int i, int total, int[] stones, int stoneSum, int target) {
        if (total >= target || i == stones.length) {
            return Math.abs(total - (stoneSum - total));
        }
        return Math.min(dfs(i + 1, total, stones, stoneSum, target),
            dfs(i + 1, total + stones[i], stones, stoneSum, target));
    }
}