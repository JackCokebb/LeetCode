class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) return mid;

            // System.out.println("mid: " + mid + ", left: " + left + ", right: " + right);
            // System.out.println("midVal: " + nums[mid] + ", leftVal: " + nums[left] + ", rightVal: " + nums[right]);

            if (isAscending(nums[left], nums[mid])) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                    // System.out.println("right = mid - 1");
                } else {
                    left = mid + 1;
                    // System.out.println("left = mid + 1");
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                    // System.out.println("left = mid + 1");
                } else {
                    right = mid - 1;
                    // System.out.println("right = mid - 1;");
                }
            }
        }

        return -1;
    }

    private boolean isAscending(int left, int right) {
        if (left <= right) return true;
        else return false;
    }
}