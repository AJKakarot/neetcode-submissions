class Solution {
    public String reorganizeString(String s) {

        int n = s.length();

        // Step 1: Frequency count
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // Impossible case check
            if (freq.get(ch) > (n + 1) / 2) {//(n+1)/2 se ceil milta h trick
                return "";
            }
        }

        // Step 2: Max-Heap (highest frequency pehle)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder ans = new StringBuilder();

        // Cooldown buffer — pichla use hua character yaha "ruka" rahega
        Pair prev = new Pair('#', 0);

        // Step 3: Greedy placement with cooldown trick
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();     // sabse zyada freq wala nikaalo
            ans.append(curr.ch);
            curr.freq--;

            // Pichla character (agar abhi bhi bacha hai) wapas heap mein daalo
            if (prev.freq > 0) {
                pq.offer(prev);
            }

            // Current ko naya "prev" bana do (cooldown mein bhej do)
            prev = curr;
        }

        // Agar poori string place nahi ho payi, matlab kahin adjacent duplicate ban jaata
        return ans.length() == n ? ans.toString() : "";
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