class Solution {

    Map<Integer, Set<Integer>> richerMap = new HashMap<>();
    int[] answer;
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        this.quiet = quiet;
        answer = new int[quiet.length];
        Arrays.fill(answer, -1);

        for (int[] r : richer) {
            Set<Integer> richerSet = richerMap.getOrDefault(r[1], new HashSet<>());
            richerSet.add(r[0]);
            richerMap.put(r[1], richerSet);
        }

        for (int i = 0; i < quiet.length; i++) {
            dfs(i);
        }

        return answer;
    }

    private int dfs(int x) {

        if (answer[x] == -1) {
            answer[x] = x;
            for(int y : richerMap.getOrDefault(x, new HashSet<>())) {
                int quietest = dfs(y);
                if(quiet[answer[x]] > quiet[quietest]) {
                    answer[x] = quietest;
                }
            }
            
        }

        return answer[x];
    }
}