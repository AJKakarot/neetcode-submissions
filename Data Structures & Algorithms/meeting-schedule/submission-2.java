class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort by start time
        intervals.sort((a, b) -> a.start - b.start);

        // Check overlap
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }
}