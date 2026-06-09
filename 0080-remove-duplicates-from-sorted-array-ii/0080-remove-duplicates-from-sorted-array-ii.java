class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int targetIdx = 2;
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[targetIdx - 2] != nums[i]) {
                nums[targetIdx] = nums[i];
                targetIdx++;
            }
        }

        return targetIdx;
    }
}