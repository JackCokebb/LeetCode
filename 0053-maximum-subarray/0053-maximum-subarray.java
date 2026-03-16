class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] maxVals = new int[n];
        int maxVal = nums[0];

        maxVals[0] = nums[0];

        for(int i = 1 ; i < n ; i++) {
            maxVals[i] = Math.max(maxVals[i - 1] + nums[i], nums[i]);
            maxVal = Math.max(maxVal, maxVals[i]);
        }

        return maxVal;
    }
}