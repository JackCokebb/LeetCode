class MinStack {

    int minVal;
    ArrayDeque<Integer> stack;
    PriorityQueue<Integer> minHeap ;

    public MinStack() {
        minVal = Integer.MAX_VALUE;
        stack = new ArrayDeque<Integer>();
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        minHeap.add(val);
    }
    
    public void pop() {
        if (stack.peek() != null) {
            minHeap.remove(stack.pollLast());
        }
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */