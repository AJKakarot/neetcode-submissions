import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: Frequency count
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Max-Heap banao (sirf non-zero frequencies daalo)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        // Step 3: Cooldown queue — [remaining_freq, availableAtTime]
        Queue<int[]> cooldownQueue = new LinkedList<>();

        int time = 0;

        // Step 4: Simulate time, unit by unit
        while (!pq.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int currFreq = pq.poll() - 1;   // task ko is slot mein use kiya

                if (currFreq > 0) {
                    // abhi bhi bacha hai, cooldown mein bhej do
                    cooldownQueue.offer(new int[]{currFreq, time + n});
                }
            }
            // agar pq empty tha is slot mein, matlab ye idle slot tha (implicitly)

            // Check: kya cooldown queue ke front wale ka available-time aa gaya?
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                pq.offer(cooldownQueue.poll()[0]);
            }
        }

        return time;
    }

}