class Solution {
    public :
        bool solve(int idx, int open, string& s, int n) {
        // String finished
        if (idx == n) {
            return open == 0;
        }

        bool isValid = false;

        // '*'
        if (s[idx] == '*') {
            // '*' = '('
            isValid |= solve(idx + 1, open + 1, s, n);

            // '*' = ''
            isValid |= solve(idx + 1, open, s, n);

            // '*' = ')'
            if (open > 0) {
                isValid |= solve(idx + 1, open - 1, s, n);
            }
        }

        // '('
        else if (s[idx] == '(') {
            isValid |= solve(idx + 1, open + 1, s, n);
        }

        // ')'
        else {
            if (open > 0) {
                isValid |= solve(idx + 1, open - 1, s, n);
            }
        }

        return isValid;
    }

    bool checkValidString(string s) {
        int n = s.length();

        return solve(0, 0, s, n);
    }
};