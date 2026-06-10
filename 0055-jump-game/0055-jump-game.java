class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < Math.min(nums.length, i + nums[i] + 1); j++) {
                if (dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }
}