class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int maxDepth = triangle.size();
        int[] dp = new int[maxDepth];

        for (int j = 0; j < maxDepth; j++) {
            dp[j] = triangle.get(maxDepth - 1).get(j);
        }

        for (int i =  maxDepth - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}