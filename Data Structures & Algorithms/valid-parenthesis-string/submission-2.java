class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> extraOpenBrackets = new Stack<>();
        Stack<Integer> aestrick = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                extraOpenBrackets.push(i);
            }

            else if (s.charAt(i) == '*') {
                aestrick.push(i);
            }

            else { // ')'

                // First try to match with '('
                if (!extraOpenBrackets.isEmpty()) {
                    extraOpenBrackets.pop();
                }

                // Otherwise use '*'
                else if (!aestrick.isEmpty()) {
                    aestrick.pop();
                }

                // Nothing available to match ')'
                else {
                    return false;
                }
            }
        }

        // Match remaining '(' with '*'
        while (!extraOpenBrackets.isEmpty()) {

            if (aestrick.isEmpty()) {
                return false;
            }

            // '*' must come AFTER '('
            if (extraOpenBrackets.peek() > aestrick.peek()) {
                return false;
            }

            extraOpenBrackets.pop();
            aestrick.pop();
        }

        return true;
    }
}