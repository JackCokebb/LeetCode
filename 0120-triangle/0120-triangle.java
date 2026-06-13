class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int maxDepth = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < maxDepth; i++) {
            dp.add(new ArrayList<>());
        }

        for (int i : triangle.get(maxDepth - 1)) {
            dp.get(maxDepth - 1).add(i);
        }

        for (int i =  maxDepth - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            List<Integer> prev = dp.get(i + 1);
            for (int j = 0; j < curr.size(); j++) {
                dp.get(i).add(Math.min(curr.get(j) + prev.get(j), curr.get(j) + prev.get(j + 1)));
            }
        }

        return dp.get(0).get(0);
    }
}