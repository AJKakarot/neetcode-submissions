class Solution {
    int[][] t = new int[5001][2];

    int maxP(int[] prices, int day, int n, int buy) {
        if (day >= n)
            return 0;

        if (t[day][buy] != -1)
            return t[day][buy];

        int profit = 0;

        // Buy
        if (buy == 1) {
            int consider = maxP(prices, day + 1, n, 0) - prices[day];
            int notConsider = maxP(prices, day + 1, n, 1);

            profit = Math.max(profit, Math.max(consider, notConsider));
        }
        // Sell
        else {
            int consider = maxP(prices, day + 2, n, 1) + prices[day];
            int notConsider = maxP(prices, day + 1, n, 0);

            profit = Math.max(profit, Math.max(consider, notConsider));
        }

        return t[day][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        for (int i = 0; i < 5001; i++) {
            t[i][0] = -1;
            t[i][1] = -1;
        }

        return maxP(prices, 0, n, 1);
    }
}