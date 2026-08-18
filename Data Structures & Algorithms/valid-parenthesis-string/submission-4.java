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

    public boolean solve(int index, int open, String s) {

        // Base case:
        // Puri string process ho gayi
        if (index == s.length()) {
            return open == 0;
        }

        // Current character '('
        if (s.charAt(index) == '(') {

            // '(' mila, to ek open bracket increase hoga
            return solve(index + 1, open + 1, s);
        }

        // Current character ')'
        else if (s.charAt(index) == ')') {

            // ')' tabhi valid hai jab koi '(' open ho
            if (open > 0) {
                return solve(index + 1, open - 1, s);
            }

            // Koi '(' available nahi hai
            return false;
        }

        // Current character '*'
        else {

            // '*' ko '(' maan lo
            boolean asOpen =
                    solve(index + 1, open + 1, s);

            // '*' ko ')' maan lo
            boolean asClose = false;

            if (open > 0) {
                asClose =
                        solve(index + 1, open - 1, s);
            }

            // '*' ko empty string "" maan lo
            boolean asEmpty =
                    solve(index + 1, open, s);

            // Koi bhi ek possibility valid hui
            // to answer true hoga
            return asOpen || asClose || asEmpty;
        }
    }

    public boolean checkValidString(String s) {

        // index = 0
        // initially koi '(' open nahi hai
        return solve(0, 0, s);
    }
}





