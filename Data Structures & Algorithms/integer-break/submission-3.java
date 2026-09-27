

class Solution {
    private int[] t;

    private int solve(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }

        // Already calculated
        if (t[n] != -1) {
            return t[n];
        }

        int result = Integer.MIN_VALUE;

        // Break n into i + (n-i)
        for (int i = 1; i < n; i++) {
            int product = i * Math.max(n - i, solve(n - i));

            result = Math.max(result, product);
        }

        // Store and return
        return t[n] = result;
    }

    public int integerBreak(int n) {
        t = new int[n + 1];
        Arrays.fill(t, -1);

        return solve(n);
    }
}