

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max-Heap: [frequency, character]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        if (a > 0)
            maxHeap.offer(new int[] {a, 'a'});
        if (b > 0)
            maxHeap.offer(new int[] {b, 'b'});
        if (c > 0)
            maxHeap.offer(new int[] {c, 'c'});

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll(); // sabse zyada frequency wala

            int len = result.length();

            // Check: kya last 2 characters already 'first' ke character jaise hain?
            if (len >= 2 && result.charAt(len - 1) == first[1]
                && result.charAt(len - 2) == first[1]) {
                // Is character ko abhi use nahi kar sakte, doosra try karo
                if (maxHeap.isEmpty()) {
                    break; // koi aur option nahi, ruk jao
                }

                int[] second = maxHeap.poll();
                result.append((char) second[1]);
                second[0]--;

                if (second[0] > 0) {
                    maxHeap.offer(second);
                }

                // 'first' ko wapas heap mein daal do (use nahi kiya abhi)
                maxHeap.offer(first);

            } else {
                // Safe hai use karne ke liye
                result.append((char) first[1]);
                first[0]--;

                if (first[0] > 0) {
                    maxHeap.offer(first);
                }
            }
        }

        return result.toString();
    }
}