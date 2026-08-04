class Solution {

    // Phone keypad mapping
    String[] map = {
        "", "",      // 0,1
        "abc",       // 2
        "def",       // 3
        "ghi",       // 4
        "jkl",       // 5
        "mno",       // 6
        "pqrs",      // 7
        "tuv",       // 8
        "wxyz"       // 9
    };

    private void solve(int index,
                       String digits,
                       StringBuilder sb,
                       List<String> result) {

        // Base Case
        // All digits are processed
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        // Get letters of current digit
        String letters = map[digits.charAt(index) - '0'];

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {

            // Choose
            sb.append(letters.charAt(i));

            // Explore
            solve(index + 1,
                  digits,
                  sb,
                  result);

            // Backtrack (Undo)
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        // Edge Case
        if (digits.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();

        solve(0,
              digits,
              sb,
              result);

        return result;
    }
}