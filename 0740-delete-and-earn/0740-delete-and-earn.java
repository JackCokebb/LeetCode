class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] bucket = new int[10001];
        int[] dp = new int[10001];
        for (int num : nums) {
            bucket[num] += num;
        }

        dp[0] = 0;
        dp[1] = bucket[1];

        for(int i = 2 ; i < 10001 ; i++) {
            dp[i] = Math.max(dp[i - 1], bucket[i] + dp[i - 2]);
        }

        return dp[10000];
    }
}