class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int n = pairs.length;
        int curr = Integer.MIN_VALUE;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (curr < pairs[i][0]) {
                curr = pairs[i][1];
                answer++;
            }
        }

        return answer;
    }
}