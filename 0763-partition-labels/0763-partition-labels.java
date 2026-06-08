class Solution {
    public List<Integer> partitionLabels(String s) {
        boolean[] visited = new boolean[27];
        List<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        char curr = s.charAt(0);

        right = setRight(s, left);

        while (left < s.length()) {
            for (int i = left + 1 ; i < right ; i++) {
                curr = s.charAt(i);
                //System.out.println("i: " + i + ", left: " + left + ", right: " + right + ", curr: " + curr);
                if (visited[curr - 'a']) {
                    continue;
                }

                visited[curr - 'a'] = true;

                for (int j = s.length() - 1 ; j >= right ; j--) {
                    //System.out.println("j: " + j + ", s.charAt(j): " + s.charAt(j) + ", curr: " + curr);
                    if (s.charAt(j) == curr) {
                        right = j + 1;
                        break;
                    }
                }
            }
            result.add(right - left);
            left = right;
            right = setRight(s, left);
        }

        return result;
    }

    private int setRight(String s, int left) {
        for (int i = s.length() - 1 ; i >= left ; i--) {
            if (s.charAt(i) == s.charAt(left)) {
                return i + 1;
            }
        }

        return left + 1;
    }
}