class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Case 1
        // Current interval is completely left
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Case 2
        // Overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        // Add merged interval
        result.add(newInterval);

        // Case 3
        // Remaining intervals
        while (i < n) {
            result.add(intervals[i]);

            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}