class Solution {

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("C")) {

                // Remove previous score
                stack.pop();

            } else if (op.equals("D")) {

                // Double previous score
                stack.push(stack.peek() * 2);

            } else if (op.equals("+")) {

                // Last score
                int first = stack.pop();

                // Second last score
                int second = stack.peek();

                // Restore removed score
                stack.push(first);

                // Push sum
                stack.push(first + second);

            } else {

                // Normal number
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}