class MinStack {

    Deque<Integer> stack;
    PriorityQueue<Integer> pq;

    public MinStack() {
        stack = new ArrayDeque<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int value) {
        stack.addFirst(value);
        pq.add(value);
    }
    
    public void pop() {
        int polled = stack.pollFirst();
        pq.remove(polled);
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return pq.peek();
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