class Solution {
    public String decodeString(String s) {

        int n = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> sbStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + c - '0';
            } else if (c == '[') {
                stack.addLast(n);
                n = 0;
                sbStack.addLast(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = sb;
                int x = stack.pollLast();
                sb = sbStack.pollLast();
                while (x > 0) {
                    sb.append(temp);
                    x--;
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}