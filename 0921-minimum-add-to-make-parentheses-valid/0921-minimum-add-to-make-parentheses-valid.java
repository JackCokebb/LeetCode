class Solution {
    public int minAddToMakeValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addLast(c);
            } else if (c == ')') {
                if (stack.peekLast() != null && stack.peekLast() == '(') {
                    stack.pollLast();
                } else {
                    stack.addLast(c);
                }
            }
        }

        return stack.size();
    }
}