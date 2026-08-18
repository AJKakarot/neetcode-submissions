// class Solution {
//     public boolean checkValidString(String s) {
//         Stack<Integer> extraOpenBrackets = new Stack<>();
//         Stack<Integer> aestrick = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 extraOpenBrackets.push(i);
//             }

//             else if (s.charAt(i) == '*') {
//                 aestrick.push(i);
//             }

//             else { // ')'

//                 // First try to match with '('
//                 if (!extraOpenBrackets.isEmpty()) {
//                     extraOpenBrackets.pop();
//                 }

//                 // Otherwise use '*'
//                 else if (!aestrick.isEmpty()) {
//                     aestrick.pop();
//                 }

//                 // Nothing available to match ')'
//                 else {
//                     return false;
//                 }
//             }
//         }

//         // Match remaining '(' with '*'
//         while (!extraOpenBrackets.isEmpty()) {
//             if (aestrick.isEmpty()) {
//                 return false;
//             }

//             // '*' must come AFTER '('
//             if (extraOpenBrackets.peek() > aestrick.peek()) {
//                 return false;
//             }

//             extraOpenBrackets.pop();
//             aestrick.pop();
//         }

//         return true;
//     }
// }

//================================================

class Solution {
    // memo[index][open]
    // 0 = not calculated
    // 1 = true
    // 2 = false
    int[][] memo;

    public boolean solve(int index, int open, String s) {
        // Base case:
        // Puri string process ho gayi
        if (index == s.length()) {
            return open == 0;
        }

        // Agar current state pehle calculate ho chuki hai
        if (memo[index][open] != 0) {
            return memo[index][open] == 1;
        }

        boolean result = false;

        // Current character '('
        if (s.charAt(index) == '(') {
            result = solve(index + 1, open + 1, s);
        }

        // Current character ')'
        else if (s.charAt(index) == ')') {
            // ')' ko tabhi close kar sakte hain
            // jab koi '(' open ho
            if (open > 0) {
                result = solve(index + 1, open - 1, s);
            }
        }

        // Current character '*'
        else {
            // '*' = '('
            boolean asOpen = solve(index + 1, open + 1, s);

            // '*' = ')'
            boolean asClose = false;

            if (open > 0) {
                asClose = solve(index + 1, open - 1, s);
            }

            // '*' = empty
            boolean asEmpty = solve(index + 1, open, s);

            // Koi bhi ek possibility valid ho
            result = asOpen || asClose || asEmpty;
        }

        // Current state ka answer save karo
        memo[index][open] = result ? 1 : 2;

        return result;
    }

    public boolean checkValidString(String s) {
        int n = s.length();

        // open ki maximum value n ho sakti hai
        memo = new int[n][n + 1];

        return solve(0, 0, s);
    }
}
