class Solution {

    // Check if all packages can be shipped within 'days'
    // using the given ship capacity.
    public boolean canShip(int[] weights, int days, int capacity) {

        int usedDays = 1;      // Start with Day 1
        int currentLoad = 0;   // Current weight loaded in the truck

        for (int weight : weights) {

            // If adding this package exceeds capacity,
            // send the current truck and start a new day.
            if (currentLoad + weight > capacity) {
                usedDays++;
                currentLoad = weight;   // New day's first package
            } else {
                currentLoad += weight;  // Add package to current day
            }
        }

        return usedDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // low = maximum package weight
        // high = sum of all package weights
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // Binary Search on Answer
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                // Capacity works, try a smaller one
                high = mid - 1;
            } else {
                // Capacity is too small
                low = mid + 1;
            }
        }

        return low;
    }
}