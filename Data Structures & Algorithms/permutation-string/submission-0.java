class Solution {

    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer than s2, permutation is impossible
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency of s1
        int[] s1Freq = new int[26];

        // Frequency of current window in s2
        int[] windowFreq = new int[26];

        // Count frequency of characters in s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int windowSize = s1.length();

        // Build the first window
        for (int i = 0; i < windowSize; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Compare first window
        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        // Slide the window
        for (int right = windowSize; right < s2.length(); right++) {

            // Add the new character entering the window
            windowFreq[s2.charAt(right) - 'a']++;

            // Remove the leftmost character leaving the window
            windowFreq[s2.charAt(right - windowSize) - 'a']--;

            // Compare both frequency arrays
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}