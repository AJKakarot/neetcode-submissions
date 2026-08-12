class Solution {
    public int[] countBits(int n) {

        int[] bits = new int[n + 1];

        // Start from 1 because bits[0] = 0
        for (int i = 1; i <= n; i++) {

            // i >> 1 removes the last binary bit
            // i & 1 tells whether the last bit was 1
            bits[i] = bits[i >> 1] + (i & 1);
        }

        return bits;
    }
}