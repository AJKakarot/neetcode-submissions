

class Solution {
    public String reorganizeString(String s) {

        // Step 1: Count frequency
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // Impossible case
            if (freq.get(ch) > (s.length() + 1) / 2) {
                return "";
            }
        }

        // Step 2: Max Heap (Higher frequency first)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> b.freq - a.freq);

        for (char ch : freq.keySet()) {
            pq.offer(new Pair(ch, freq.get(ch)));
        }

        StringBuilder ans = new StringBuilder();

        Pair prev = new Pair('#', 0);

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            ans.append(curr.ch);
            curr.freq--;

            // Previous character ko wapas heap me daalo
            if (prev.freq > 0) {
                pq.offer(prev);
            }

            // Current ko previous bana do
            prev = curr;
        }

        return ans.toString();
    }

    static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}