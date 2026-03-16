class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxVal = nums[0];
        int total = 0;

        for (int num : nums) {
            if (total < 0) {
                total = 0;
            }
            total += num;
            maxVal = Math.max(total, maxVal);
        }

        return maxVal;
    }
}