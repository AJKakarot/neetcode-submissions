class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // {enqueueTime, processingTime, originalIndex}
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap: {processingTime, originalIndex}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] result = new int[n];

        long currTime = 0;
        int idx = 0;
        int ansIdx = 0;

        while (idx < n || !pq.isEmpty()) {

            // Jump to next task if CPU is idle
            if (pq.isEmpty() && currTime < sortedTasks[idx][0]) {
                currTime = sortedTasks[idx][0];
            }

            // Push all available tasks into heap
            while (idx < n && sortedTasks[idx][0] <= currTime) {
                pq.offer(new int[]{
                        sortedTasks[idx][1], // processing time
                        sortedTasks[idx][2]  // original index
                });
                idx++;
            }

            int[] currTask = pq.poll();

            currTime += currTask[0];
            result[ansIdx++] = currTask[1];
        }

        return result;
    }
}