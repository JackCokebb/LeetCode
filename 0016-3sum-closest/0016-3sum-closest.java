class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = 100000;

        
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            if(target + Math.abs(target - minDiff) <= nums[i] + nums[i + 1] + nums[i + 2]) return minDiff;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int curr = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - curr) < Math.abs(target - minDiff)) {
                    minDiff = curr;
                }

                if(curr < target) {
                    left++;
                } else if (curr > target) {
                    right--;
                } else {
                    return curr;
                }
            }
        }

        return minDiff;
    }
}