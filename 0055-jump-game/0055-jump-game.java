class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int n = nums.length - 1;
        int max = 0;

        while (i <= max) {
            max = Math.max(max, i + nums[i]);

            if (max >= n) return true;
            i++;
        }

        return false;
    }
}