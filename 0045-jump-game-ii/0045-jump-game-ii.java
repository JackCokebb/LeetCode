class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 0 ; i < n - 1 ; i++) {
            for(int j = 1 ; j <= nums[i] ; j++) {
                if (i + j >= n) continue;
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                //System.out.println(Arrays.toString(dp));
            }
        }

        return dp[n - 1];
    }
}