class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Minimum possible speed
        int left = 1;

        // Maximum possible speed = maximum pile
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary Search on Answer
        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate total hours required at speed = mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // Ceil(pile / mid)
            }

            // If Koko can finish within h hours,
            // try to find an even smaller valid speed
            if (hours <= h) {
                right = mid;
            }
            // Otherwise increase the speed
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}