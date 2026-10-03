class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] score = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            score[a]--;  // a trusts someone
            score[b]++;  // someone trusts b
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return score[i]+1;
            }
        }

        return -1;
    }
}