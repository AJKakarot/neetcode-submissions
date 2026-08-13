class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long k = n - 1;

        int bit = 0;

        while (k > 0) {
            // Find a zero bit in x
            while ((ans & (1L << bit)) != 0) {
                bit++;
            }

            // Put current bit of k into this zero position
            if ((k & 1) != 0) {
                ans |= (1L << bit);
            }

            k >>= 1;
            bit++;
        }

        return ans;
    }
}