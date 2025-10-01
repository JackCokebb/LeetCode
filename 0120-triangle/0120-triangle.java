class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int triSize = triangle.size();
        int n = 0;
        for (int i = 1 ; i <= triSize ; i++) {
            n += i;
        }

        int[] dp = new int[n + 1];

        for (int i = 1 ; i <= triSize ; i++) {
            int idx = getSumBeforeTarget(triSize);
            dp[idx + i] = triangle.get(triSize - 1).get(i - 1);
        }

        for (int i = triSize - 1 ; i > 0 ; i--) {
            int idx = getSumBeforeTarget(i);
            int nextRowIdx = getSumBeforeTarget(i + 1);

            for (int j = 1 ; j <= i ; j++) {
                dp[idx + j] = Math.min(dp[nextRowIdx + j], dp[nextRowIdx + j + 1]) + triangle.get(i - 1).get(j - 1);
            }

        }

        return dp[1];
    }

    private int getSumBeforeTarget(int t) {
        int n = 0;
        for (int i = 1 ; i < t ; i++) {
            n += i;
        }

        return n;
    }
}