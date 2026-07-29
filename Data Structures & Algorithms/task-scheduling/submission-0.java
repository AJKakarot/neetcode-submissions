class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count how many tasks have the maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        // Calculate minimum required slots
        int minTime = (maxFreq - 1) * (n + 1) + maxCount;

        // Answer cannot be less than total number of tasks
        return Math.max(tasks.length, minTime);
    }
}