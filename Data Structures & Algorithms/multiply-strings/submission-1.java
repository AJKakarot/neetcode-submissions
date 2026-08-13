class Solution {
    public String multiply(String num1, String num2) {
        // If either number is 0, answer is immediately 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // Maximum number of digits in multiplication = m + n
        int[] result = new int[m + n];

        // Multiply every digit of num1 with every digit of num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Convert character digit into integer
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Position where multiplication result will be stored
                int p1 = i + j;
                int p2 = i + j + 1;

                // Multiply current digits and add existing value
                int product = digit1 * digit2 + result[p2];

                // Store the single digit at p2
                result[p2] = product % 10;

                // Carry goes to p1
                result[p1] += product / 10;
            }
        }

        // Convert result array into String
        StringBuilder sb = new StringBuilder();

        // Skip leading zeros
        for (int digit : result) {
            if (sb.length() == 0 && digit == 0) {
                continue;
            }

            sb.append(digit);
        }

        return sb.toString();
    }
}