class Solution {

    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {

            // Excel starts from 1 instead of 0
            columnNumber--;

            // Find current character
            char ch = (char) ('A' + (columnNumber % 26));

            // Add character
            sb.append(ch);

            // Move to next position
            columnNumber /= 26;
        }

        // Reverse because characters are generated from right to left
        return sb.reverse().toString();
    }
}