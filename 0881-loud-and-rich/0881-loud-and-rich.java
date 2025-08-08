class Solution {

    Map<Integer, Set<Integer>> richerHis = new HashMap<>();

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int[] answer = new int[quiet.length];
        Map<Integer, Set<Integer>> richerMap = new HashMap<>();
        

        for (int i = 0; i < quiet.length; i++) {
            Set<Integer> richerSet = richerMap.getOrDefault(i, new HashSet<>());
            richerSet.add(i);
            richerMap.put(i, richerSet);
        }

        for (int[] r : richer) {
            Set<Integer> richerSet = richerMap.getOrDefault(r[1], new HashSet<>());
            richerSet.add(r[0]);
            richerMap.put(r[1], richerSet);
        }

        for (int i = 0; i < quiet.length; i++) {
            Set<Integer> richerSet = findRicher(i, richerMap);
            int quietVal = Integer.MAX_VALUE;
            int quietIdx = 0;

            for (int j : richerSet) {
                if (quiet[j] < quietVal) {
                    quietIdx = j;
                    quietVal = quiet[j];
                }
            }
            answer[i] = quietIdx;
        }

        return answer;
    }

    private Set<Integer> findRicher(int x, Map<Integer, Set<Integer>> richerMap) {

        if(richerHis.get(x) != null) {
            return richerHis.get(x);
        }

        Set<Integer> richerSet = richerMap.getOrDefault(x, new HashSet<>());

        if (richerSet.isEmpty()) {
            return richerSet;
        } else {
            Set<Integer> newSet = new HashSet<>();
            newSet.addAll(richerSet);
            for (int i : richerSet) {
                if (i == x)
                    continue;
                newSet.addAll(findRicher(i, richerMap));
            }

            richerHis.put(x, newSet);
            return newSet;
        }
    }
}