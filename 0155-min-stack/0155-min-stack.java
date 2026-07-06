class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int value) {
        stack.addFirst(value);
        if (minStack.isEmpty()) {
            minStack.addFirst(value);
        } else {
            if (minStack.peek() >= value) {
                minStack.addFirst(value);
            }
        }
    }
    
    public void pop() {
        if (minStack.peek().equals(stack.peek())) {
            minStack.removeFirst();
        }

        stack.removeFirst();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */