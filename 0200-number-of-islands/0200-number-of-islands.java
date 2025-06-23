class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == '1') {
                    queue.addLast(new int[]{j, i});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            if (grid[currPos[1]][currPos[0]] == '0') {
                continue;
            }
            result++;

            Deque<int[]> stack = new ArrayDeque<>();
            stack.add(currPos);

            while(!stack.isEmpty()) {
                int[] curr = stack.pollLast();
                
                if (grid[curr[1]][curr[0]] == '0') {
                    continue;
                }

                grid[curr[1]][curr[0]] = '0';

                for (int i = 0 ; i < 4 ; i++) {
                    int nextX = dx[i] + curr[0];
                    int nextY = dy[i] + curr[1];

                    if (nextX >= grid[0].length || nextX < 0 || nextY >= grid.length || nextY < 0) {
                        continue;
                    }

                    stack.addLast(new int[]{nextX, nextY});
                }
            
            }
        }

        return result;
    }
}