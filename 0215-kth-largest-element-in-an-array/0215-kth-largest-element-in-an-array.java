class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[left];
        }
        
        int pivot = partition(nums, left, right);

        if (pivot >= k) {
            return quickSelect(nums, left, pivot, k);
        } else {
            return quickSelect(nums, pivot + 1, right, k);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start + (end - start) / 2];
        int left = start;
        int right = end;

        while (true) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left >= right) return right;

            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}