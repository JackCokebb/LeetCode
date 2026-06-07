class Solution {

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {-1, 1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> results = new ArrayList<>();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (canReachByDfs(heights, x, y, m ,n)) {
                    results.add(List.of(y, x));
                }
            }
        }

        return results;
    }
    private boolean canReachByDfs(int[][] heights, int x, int y, int m, int n) {

        Deque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[]{x, y});
        boolean[][] visited = new boolean[m][n];
        visited[y][x] = true;
        boolean pOk = false;
        boolean aOk = false;

        while (!stack.isEmpty()) {
            int[] curr = stack.pollLast();
            int currX = curr[0];
            int currY = curr[1];
            
            visited[currY][currX] = true;

            if ((currY == 0 || currX == 0)) {
                pOk = true;
            }

            if ((currY >= m - 1 || currX >= n - 1)) {
                aOk = true;
            }

            if (pOk && aOk) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (heights[nextY][nextX] > heights[currY][currX]) {
                    continue;
                }

                if (!visited[nextY][nextX]){
                    stack.addLast(new int[]{nextX, nextY});
                }                
            }
        }

        return false;
    }
}