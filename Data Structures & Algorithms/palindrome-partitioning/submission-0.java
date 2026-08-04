class Solution {

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    private void solve(int index,
                       String s,
                       List<String> temp,
                       List<List<String>> result) {

        // Base Case
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Try every substring
        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                // Choose
                temp.add(s.substring(index, i + 1));

                // Explore
                solve(i + 1, s, temp, result);

                // Backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        solve(0, s, temp, result);

        return result;
    }
}