class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int remove = 0;

        // First interval is current
        int[] current = intervals[0];

        // Compare current with next interval
        for (int i = 1; i < intervals.length; i++) {
            // Overlap
            if (intervals[i][0] < current[1]) {
                // One interval must be removed
                remove++;

                // Keep the interval with smaller end
                if (intervals[i][1] < current[1]) {
                    current = intervals[i];
                }
            }

            // No Overlap
            else {
                current = intervals[i];
            }
        }

        return remove;
    }
}