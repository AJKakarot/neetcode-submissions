class Solution {
    public int reverseBits(int n) {
        int result = 0;

        // Exactly 32 bits process karni hain
        for (int i = 0; i < 32; i++) {
            // n ka last bit nikalo
            int bit = n & 1;

            // Result mein space banao
            result = result << 1;

            // Nikali hui bit ko result mein add karo
            result = result | bit;

            // n ki next bit par jao
            n = n >>> 1;
        }

        return result;
    }
}