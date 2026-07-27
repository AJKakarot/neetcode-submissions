
class Solution {

    public int lastStoneWeight(int[] stones) {

        // Create a Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Continue until only one or no stone remains
        while (maxHeap.size() > 1) {

            // Remove the largest stone
            int first = maxHeap.poll();

            // Remove the second largest stone
            int second = maxHeap.poll();

            // If the stones are not equal,
            // insert their difference back into the heap
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        // If no stones are left, return 0
        if (maxHeap.isEmpty()) {
            return 0;
        }

        // Return the weight of the last remaining stone
        return maxHeap.peek();
    }
}