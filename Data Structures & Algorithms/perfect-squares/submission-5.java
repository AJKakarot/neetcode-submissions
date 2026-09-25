import java.util.Arrays;

class Solution {
    private int[] t = new int[10001];

    private int minSquares(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }

        // Already calculated
        if (t[n] != -1) {
            return t[n];
        }

        int minCount = Integer.MAX_VALUE;

        // Try every possible perfect square
        for (int i = 1; i * i <= n; i++) {
            int current = 1 + minSquares(n - i * i);

            minCount = Math.min(minCount, current);
        }

        // Store answer in memo
        return t[n] = minCount;
    }

    public int numSquares(int n) {
        // -1 means "not calculated yet"
        Arrays.fill(t, -1);

        return minSquares(n);
    }
}