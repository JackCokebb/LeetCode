class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();


        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {

                stack.addLast(c);
                continue;
            }
            
            if (stack.peekLast() == c) {
                
                stack.pollLast();
            } else {
                
                stack.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}