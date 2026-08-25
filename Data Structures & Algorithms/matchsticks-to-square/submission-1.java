class Solution {
    private boolean solve(int index, int[] matchsticks, int[] sides, int target) {
        // Base Case
        // All matchsticks are used
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target
                && sides[3] == target;
        }

        // Try placing current matchstick on each side
        for (int i = 0; i < 4; i++) {
            // Skip if current side exceeds target
            if (sides[i] + matchsticks[index] > target) {
                continue;
            }

            // Choose
            sides[i] += matchsticks[index];

            // Explore
            if (solve(index + 1, matchsticks, sides, target)) {
                return true;
            }

            // Backtrack (Undo)
            sides[i] -= matchsticks[index];
        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        // Need at least 4 matchsticks
        if (matchsticks.length < 4) {
            return false;
        }

        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        // Total length must be divisible by 4
        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        // Sort in descending order
        Arrays.sort(matchsticks);

        int left = 0;
        int right = matchsticks.length - 1;

        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;

            left++;
            right--;
        }

        int[] sides = new int[4];

        return solve(0, matchsticks, sides, target);
    }
}