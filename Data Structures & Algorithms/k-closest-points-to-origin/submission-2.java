
class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // Max Heap based on distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1])
                    - (a[0] * a[0] + a[1] * a[1])
        );

        // Add every point
        for (int[] point : points) {

            maxHeap.offer(point);

            // Keep only k closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare answer
        int[][] result = new int[k][2];

        int i = 0;

        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }
}