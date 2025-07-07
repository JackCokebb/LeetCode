class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int target = (int) Math.pow(2, n);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i < target ; i++) {
            String bit = Integer.toBinaryString(i);
            //System.out.println("bit: " + bit);
            List<Integer> curr = new ArrayList<>();
            for (int j = 0 ; j < bit.length() ; j++) {
                if (bit.charAt(bit.length() - j - 1) == '1') {
                    curr.add(nums[j]);
                }
            }
            result.add(curr);
        }

        return result;
    }
}