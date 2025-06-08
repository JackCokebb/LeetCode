class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];

        for (int i = 0 ; i < s.length() ; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];

        for (int i = 0 ; i < s.length() ; i++) {
            int curr = s.charAt(i) - 'a';
            if (visited[curr]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > curr && lastIdx[stack.peekLast()] > i) {
                
                visited[stack.pollLast()] = false;
            }

            stack.addLast(curr);
            visited[curr] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append((char) (stack.pollFirst() + 'a'));
        }

        return sb.toString();
    }
}