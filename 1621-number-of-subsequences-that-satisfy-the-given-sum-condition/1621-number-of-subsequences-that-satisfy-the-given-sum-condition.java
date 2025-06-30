class Solution {

    static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }

        int total = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {

                total = (total + power[right - left]) % MOD;
                //System.out.println("left: " + left + ", right: " + right + ", total: " + total);
                left++;

            } else {
                right--;
            }

        }

        return total;
    }
}