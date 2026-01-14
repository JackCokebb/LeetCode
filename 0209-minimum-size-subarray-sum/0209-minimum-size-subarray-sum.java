class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int right = 0;
        int minLen = 100001;
        int currSum = nums[0];
        int numsLen = nums.length;

        while(left <= right && right < numsLen) {
            if(currSum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                if(minLen == 1) return minLen;
                currSum -= nums[left];
                left += 1;
            } else {
                right += 1;
                if(right >= numsLen) break;
                currSum += nums[right];
            }
        }

        return minLen >= 100001 ? 0 : minLen;
    }
}