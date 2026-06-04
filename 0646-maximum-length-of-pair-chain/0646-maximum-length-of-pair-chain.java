class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int best = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            int tempBest = 1;
            for (int j = i + 1; j < n; j++) {
                if (pairs[i][1] < pairs[j][0]) {
                    tempBest = Math.max(tempBest, dp[j] + 1);
                }
            }
            dp[i] = tempBest;
            best = Math.max(tempBest, best);
        }

        return best;
    }
}