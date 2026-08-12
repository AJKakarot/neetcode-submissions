class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {

            // Removes the rightmost 1-bit
            n = n & (n - 1);

            count++;
        }

        return count;
    }
}