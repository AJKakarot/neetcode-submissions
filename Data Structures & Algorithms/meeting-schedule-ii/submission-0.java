/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    public int minMeetingRooms(int[][] intervals) {

        // No meetings
        if (intervals.length == 0) {
            return 0;
        }

        // Sort by meeting start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min Heap stores ending times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // First meeting gets first room
        minHeap.offer(intervals[0][1]);

        // Process remaining meetings
        for (int i = 1; i < intervals.length; i++) {

            // If earliest ending meeting is over,
            // reuse that room
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Allocate current meeting
            minHeap.offer(intervals[i][1]);
        }

        // Heap size = Minimum rooms required
        return minHeap.size();
    }
}