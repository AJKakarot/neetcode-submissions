// //1. Recursion + Memoization — Top Down

// class Solution {
//     int[] t = new int[46];

//     int solve(int n) {
//         if (n == 0 || n == 1 || n == 2)
//             return n;

//         if (t[n] != -1)
//             return t[n];

//         int a = solve(n - 1);
//         int b = solve(n - 2);

//         return t[n] = a + b;
//     }

//     public int climbStairs(int n) {
//         Arrays.fill(t, -1);
//         return solve(n);
//     }
// }


// //2. Bottom-Up DP / Tabulation

// class Solution {
//     public int climbStairs(int n) {
//         if (n == 1 || n == 2)
//             return n;

//         int[] t = new int[n + 1];

//         // t[i] = total ways to climb i stairs
//         t[0] = 0;
//         t[1] = 1;
//         t[2] = 2;

//         for (int i = 3; i <= n; i++) {
//             t[i] = t[i - 1] + t[i - 2];
//         }

//         return t[n];
//     }
// }
// 3. Space Optimized DP ⭐
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;

        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int c = a + b;

            a = b;
            b = c;
        }

        return b;
    }
}