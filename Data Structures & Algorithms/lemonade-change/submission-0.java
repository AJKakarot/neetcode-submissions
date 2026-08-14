class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            // Customer gives $5
            // No change needed
            if (bill == 5) {
                five++;
            }

            // Customer gives $10
            // Need $5 as change
            else if (bill == 10) {
                if (five == 0) {
                    return false;
                }

                five--;
                ten++;
            }

            // Customer gives $20
            // Need $15 as change
            else {
                // Greedy choice:
                // Prefer $10 + $5
                // This saves more $5 notes for future customers
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }

                // If $10 + $5 is not possible,
                // give three $5 notes
                else if (five >= 3) {
                    five -= 3;
                }

                // Cannot give $15 change
                else {
                    return false;
                }
            }
        }

        return true;
    }
}