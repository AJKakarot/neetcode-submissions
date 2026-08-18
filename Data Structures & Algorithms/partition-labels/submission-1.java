class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();

        // Store the last occurrence (last index) of every character
        int[] lastIndex = new int[26];

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int i = 0;
        int start = 0;
        int end = 0;

        while (i < n) {
            // Extend the current partition to include
            // the last occurrence of the current character
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // If current index reaches the farthest required index,
            // we can safely close this partition
            if (i == end) {
                // Partition size = end - start + 1
                result.add(end - start + 1);

                // Start the next partition
                start = end + 1;
            }

            i++;
        }

        return result;
    }
}