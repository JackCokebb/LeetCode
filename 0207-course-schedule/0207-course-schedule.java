class Solution {
    HashMap<Integer, Set<Integer>> point;
    boolean[] checked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        point = new HashMap<>();
        checked = new boolean[numCourses];

        for (int[] pre : prerequisites) {
            Set<Integer> s = point.getOrDefault(pre[0], new HashSet<>());
            s.add(pre[1]);
            point.put(pre[0], s);
        }

        for (int key : point.keySet()) {

            boolean[] visited = new boolean[numCourses];
            if (isLoop(visited, key)) {
                
                return false;
            } else {
                
                checked[key] = true;
            }
        }

        return true;
    }

    private boolean isLoop(boolean[] visited, int key) {

        if (checked[key]) return false;

        for (int k : point.getOrDefault(key, new HashSet<>())) {

            if (visited[k]) {
                
                return true;
            }

            visited[k] = true;

            if (isLoop(visited, k)) return true;

            visited[k] = false;
        }

        checked[key] = true;
        return false;
    }
}