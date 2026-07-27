

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    // Constructor
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // Heap ka size k se bada ho gaya to smallest remove kar do
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    // Stream me naya element add karo
    public int add(int val) {
        minHeap.offer(val);

        // Sirf top k largest elements hi rakho
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Heap ka top = kth largest element
        return minHeap.peek();
    }
}