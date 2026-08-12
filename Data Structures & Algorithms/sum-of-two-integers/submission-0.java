class Solution {
    public int getSum(int a, int b) {

        while (b != 0) {

            // XOR gives addition without carry
            int sum = a ^ b;

            // AND finds where carry is generated
            int carry = (a & b) << 1;

            // Update values
            a = sum;
            b = carry;
        }

        return a;
    }
}