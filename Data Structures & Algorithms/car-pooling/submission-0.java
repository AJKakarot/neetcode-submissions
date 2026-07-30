import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // Sort trips by pickup location
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        // Min Heap -> {dropLocation, passengers}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int currentPassengers = 0;

        for (int[] trip : trips) {

            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            // Remove all passengers who have already reached their destination
            while (!pq.isEmpty() && pq.peek()[0] <= from) {
                currentPassengers -= pq.poll()[1];
            }

            // Pick up new passengers
            currentPassengers += passengers;

            // Check capacity
            if (currentPassengers > capacity) {
                return false;
            }

            // Add current trip to heap
            pq.offer(new int[]{to, passengers});
        }

        return true;
    }
}