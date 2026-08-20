class Solution {
    int n;

    void removeSenator(String senate, boolean[] removed, char ch, int idx) {

        while (true) {

            if (senate.charAt(idx) == ch && !removed[idx]) {
                removed[idx] = true;
                break;
            }

            idx = (idx + 1) % n;
        }
    }

    public String predictPartyVictory(String senate) {

        n = senate.length();

        int R_Count = 0;
        for (char ch : senate.toCharArray()) {
            if (ch == 'R') {
                R_Count++;
            }
        }

        int D_Count = n - R_Count;

        int idx = 0;

        // Initially no one is removed
        boolean[] removed = new boolean[n];

        while (R_Count > 0 && D_Count > 0) {

            if (!removed[idx]) {

                if (senate.charAt(idx) == 'R') {

                    // R bans next available D
                    removeSenator(
                        senate,
                        removed,
                        'D',
                        (idx + 1) % n
                    );

                    D_Count--;

                } else {

                    // D bans next available R
                    removeSenator(
                        senate,
                        removed,
                        'R',
                        (idx + 1) % n
                    );

                    R_Count--;
                }
            }

            idx = (idx + 1) % n;
        }

        return R_Count == 0 ? "Dire" : "Radiant";
    }
}