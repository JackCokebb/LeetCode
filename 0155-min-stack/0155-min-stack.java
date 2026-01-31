class MinStack {

    List<int[]> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        
        int[] last = stack.isEmpty() ? new int[]{val, val} : stack.get(stack.size() - 1);
        int minVal = last[1] > val ? val : last[1];
        stack.add(new int[]{val, minVal});
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */