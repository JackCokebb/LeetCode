class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int answer = 0;

        counts[n - 1] = 1;

        for(int i = n - 2 ; i >= 0 ; i--) {

            int maxVal = counts[i];

            for(int j = i + 1 ; j < n ; j++) {
                if(nums[j] > nums[i] && counts[j] > maxVal) {
                    maxVal = counts[j];
                }
            }

            counts[i] = maxVal + 1;
        }

        for(int i = 0 ; i < n ; i++) {
            answer = Math.max(counts[i], answer);
        }

        return answer;
    }
}