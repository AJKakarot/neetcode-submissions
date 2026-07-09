
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        // Number of days
        int n = temperatures.length;

        // Answer array (default value is 0)
        int[] answer = new int[n];

        // Stack stores INDEXES of temperatures
        Stack<Integer> stack = new Stack<>();

        // Traverse all days
        for (int i = 0; i < n; i++) {

            // While current temperature is warmer than
            // the temperature at the top index of stack
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                // Previous day's index
                int previousIndex = stack.pop();

                // Number of days waited for a warmer temperature
                answer[previousIndex] = i - previousIndex;
            }

            // Push current day's index
            stack.push(i);
        }

        // Remaining indexes in stack never get a warmer day
        // Their answer remains 0 (default value)

        return answer;
    }
}