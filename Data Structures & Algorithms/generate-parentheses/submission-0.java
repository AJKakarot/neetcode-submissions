class Solution {

    private void solve(int open,
                       int close,
                       int n,
                       StringBuilder sb,
                       List<String> result) {

        // Base Case
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // Choice 1 : Add '('
        if (open < n) {

            // Choose
            sb.append('(');

            // Explore
            solve(open + 1, close, n, sb, result);

            // Backtrack (Undo)
            sb.deleteCharAt(sb.length() - 1);
        }

        // Choice 2 : Add ')'
        if (close < open) {

            // Choose
            sb.append(')');

            // Explore
            solve(open, close + 1, n, sb, result);

            // Backtrack (Undo)
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solve(0, 0, n, sb, result);

        return result;
    }
}