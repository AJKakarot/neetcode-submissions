class Solution {

    public String gcdOfStrings(String str1, String str2) {

        // Check if both strings have the same repeating pattern
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of lengths
        int len = gcd(str1.length(), str2.length());

        // Return first 'len' characters
        return str1.substring(0, len);
    }

    // Euclidean Algorithm
    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}