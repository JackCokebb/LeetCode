class Solution {
    public int[] productExceptSelf(int[] nums) {
        int curr = 1;
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = 0; i < n; i++) {
            answer[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= curr;
            curr *= nums[i];
        }

        return answer;
    }
}