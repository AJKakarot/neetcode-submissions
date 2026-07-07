class Solution {

    public int characterReplacement(String s, int k) {

        // Frequency of each uppercase character
        int[] freq = new int[26];

        // Left pointer of the sliding window
        int left = 0;

        // Highest frequency of any character in the current window
        int maxFreq = 0;

        // Stores the maximum valid window length
        int maxLength = 0;

        // Expand the window using the right pointer
        for (int right = 0; right < s.length(); right++) {

            // Add current character into the window
            freq[s.charAt(right) - 'A']++;

            // Update the maximum frequency in the current window
            maxFreq = Math.max(maxFreq,
                    freq[s.charAt(right) - 'A']);

            // Current window size
            int windowSize = right - left + 1;

            // If replacements needed are greater than k,
            // shrink the window from the left
            while (windowSize - maxFreq > k) {

                // Remove left character from frequency array
                freq[s.charAt(left) - 'A']--;

                // Shrink the window
                left++;

                // Recalculate window size
                windowSize = right - left + 1;
            }

            // Update the longest valid window
            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}