class Solution {

    public String decodeString(String s) {

        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();

        String current = "";
        int num = 0;

        for (char ch : s.toCharArray()) {

            // Digit
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Opening Bracket
            else if (ch == '[') {

                numbers.push(num);
                strings.push(current);

                num = 0;
                current = "";
            }

            // Closing Bracket
            else if (ch == ']') {

                int repeat = numbers.pop();
                String previous = strings.pop();

                String temp = "";

                for (int i = 0; i < repeat; i++) {
                    temp += current;
                }

                current = previous + temp;
            }

            // Character
            else {
                current += ch;
            }
        }

        return current;
    }
}