class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            // Assume current asteroid survives
            boolean destroyed = false;

            // Collision possible only when:
            // Stack top is moving right (+)
            // Current asteroid is moving left (-)
            while (!stack.isEmpty() &&
                    stack.peek() > 0 &&
                    asteroid < 0) {

                // Current asteroid is bigger
                if (stack.peek() < -asteroid) {

                    stack.pop();

                }

                // Both are equal
                else if (stack.peek() == -asteroid) {

                    stack.pop();
                    destroyed = true;
                    break;

                }

                // Stack asteroid is bigger
                else {

                    destroyed = true;
                    break;
                }
            }

            // If current asteroid survived, push it
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] ans = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}