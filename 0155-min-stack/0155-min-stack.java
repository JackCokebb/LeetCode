class MinStack {

    List<int[]> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int value) {
        int[] last = stack.isEmpty() ? new int[] {value, value} : stack.get(stack.size() - 1);
        int minVal = last[1] > value ? value : last[1];
        stack.add(new int[] {value, minVal});
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1)[0];
    }
    
    public int getMin() {
        return stack.get(stack.size() - 1)[1];
        
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