


class Solution {

    public int lastStoneWeight(int[] stones) {

        // Max Heap banaya
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Sabhi stones heap me add karo
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Jab tak kam se kam 2 stones hain
        while (maxHeap.size() > 1) {

            // Sabse bada stone
            int first = maxHeap.poll();

            // Dusra sabse bada stone
            int second = maxHeap.poll();

            // Agar dono equal nahi hain
            if (first != second) {

                // Difference wapas heap me daal do
                maxHeap.offer(first - second);
            }
        }

        // Agar koi stone nahi bacha
        if (maxHeap.isEmpty()) {
            return 0;
        }

        // Ek stone bacha hai to wahi answer
        return maxHeap.peek();
    }
}