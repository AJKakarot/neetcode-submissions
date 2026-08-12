class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        // Process both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            // Take digit from a if available
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Take digit from b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Current binary digit
            sb.append(sum % 2);

            // Carry for next position
            carry = sum / 2;
        }

        // We calculated from right to left,
        // so reverse the answer
        return sb.reverse().toString();
    }
}