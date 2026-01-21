class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        
        
        dfs(candidates, target, new ArrayList<Integer>(), answer, 0);

        return answer;
    }

    private void dfs(int[] candidates, int target, List<Integer> temp, List<List<Integer>> answer, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start ; i < candidates.length ; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], temp, answer, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}