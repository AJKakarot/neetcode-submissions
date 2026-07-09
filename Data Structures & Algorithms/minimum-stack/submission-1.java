class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isempty) {
            minStack.push(val);
        } else if (minStack.peek >= val) {
            minStack.push(val);
        } else {
            stack.push(val);
        }
    }

    public void pop() {
        if (minStack.peek() == stack.peek()) {
            minStack.pop();
            stack.pop();

        } else {
            stack.pop();
        }
    }

    public int top() {
        stack.peek();
    }

    public int getMin() {
        minStack.peek();
    }
}
