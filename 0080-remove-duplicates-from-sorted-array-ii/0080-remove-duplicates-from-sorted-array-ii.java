class Solution {
    public int removeDuplicates(int[] nums) {
        int currNum = nums[0];
        int count = 0;
        int totalCounts = nums.length;

        for (int i = 0 ; i < nums.length ; i++) {
            
            if (currNum == nums[i]) {
                count++;

                if (count > 2) {
                    nums[i] = Integer.MAX_VALUE;
                    totalCounts--;
                }
            } else {
                currNum = nums[i];
                count = 1;
            }
        }
        
        Arrays.sort(nums);
        return totalCounts;
    }
}