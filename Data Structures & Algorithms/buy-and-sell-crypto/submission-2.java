// class Solution {
//     public int maxProfit(int[] prices) {

//         int buy = prices[0];
//         int max = 0;

//         for (int i = 1; i < prices.length; i++) {

//             // profit if we sell today
//             int current = prices[i] - buy;

//             // update max profit
//             max = Math.max(current, max);

//             // update minimum buying price
//             buy = Math.min(buy, prices[i]);
//         }

//         return max;
//     }
// }

class Solution {

    public int maxProfit(int[] prices) {

        int left = 0;
        int right = 1;

        int maxProfit = 0;

        while (right < prices.length) {

            // Profitable transaction
            if (prices[right] > prices[left]) {

                int profit = prices[right] - prices[left];

                maxProfit = Math.max(maxProfit, profit);

            }
            // Found a cheaper buying day
            else {

                left = right;
            }

            right++;
        }

        return maxProfit;
    }
}




// Initially

// 7 1 5 3 6 4

// L R

// Window

// Buy ---- Sell

// Profit

// 1-7 ❌

// Window reset

// 7 1 5 3 6 4

//   L R