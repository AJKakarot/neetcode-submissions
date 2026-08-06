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
    public int minMeetingRooms(List<Interval> intervals) {
        // No meetings
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Sort by start time
        intervals.sort((a, b) -> a.start - b.start);

        // Min Heap stores ending times
        // Because for every new meeting, we only need to know which room becomes free the earliest.
        // A Min Heap keeps the smallest end time at the top, so we can check room availability in
        // O(1) using peek() and update it efficiently in O(log n) using poll() and offer().
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // First meeting gets first room
        minHeap.offer(intervals.get(0).end);

        // Process remaining meetings
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            // Room becomes free
            if (current.start >= minHeap.peek()) {
                minHeap.poll();
            }

            // Allocate room
            minHeap.offer(current.end);
        }

        // Heap size = Minimum rooms required
        return minHeap.size();
    }
}