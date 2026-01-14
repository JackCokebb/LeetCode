class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            long need = prefix[i] + target;
            int j = lowerBound(prefix, need); // first index with prefix[j] >= need
            if (j <= n) {
                ans = Math.min(ans, j - i);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // lower_bound on a sorted long[] array
    private int lowerBound(long[] arr, long target) {
        int lo = 0, hi = arr.length; // [lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}