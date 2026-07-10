
class Solution {

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store (position, time to reach target)
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {

            cars[i][0] = position[i];

            // Time = Distance / Speed
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars by position (ascending)
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();

        // Traverse from nearest car to farthest
        for (int i = n - 1; i >= 0; i--) {

            double currentTime = cars[i][1];

            // New fleet
            if (stack.isEmpty() || currentTime > stack.peek()) {

                stack.push(currentTime);
            }

            // Else:
            // currentTime <= stack.peek()
            // Current car catches the fleet ahead,
            // so do nothing.
        }

        return stack.size();
    }
}