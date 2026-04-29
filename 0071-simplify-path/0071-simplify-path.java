class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        
        String[] splitedPath = path.split("/");

        for (String s : splitedPath) {
            if (s.equals("..")) {
                if (deque.size() > 0) {
                    deque.removeLast();
                }
            } else if (s.equals(".")) {
                continue;
            } else if (s.equals("") || s.equals(" ")) {
                continue;
            } else {
                deque.addLast(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");

        for (String s : deque) {
            sb.append(s + "/");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}