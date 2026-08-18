class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        // Calculate total gas and total cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // If total gas is less than total cost,
        // completing the circular route is impossible
        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int startIndex = 0;

        // Try to find the valid starting station
        for (int i = 0; i < gas.length; i++) {
            // Gas gained at current station
            // minus gas required to reach next station
            currentGas += gas[i] - cost[i];

            // If gas becomes negative,
            // current start cannot reach the next station
            if (currentGas < 0) {
                // Start from the next station
                startIndex = i + 1;

                // Reset gas for the new starting point
                currentGas = 0;
            }
        }

        // Return the valid starting station
        return startIndex;
    }
}