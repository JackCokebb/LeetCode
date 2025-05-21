class Solution {

    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    public int nearestExit(char[][] maze, int[] entrance) {

        int mazeY = maze.length;
        int mazeX = maze[0].length;

        maze[entrance[0]][entrance[1]] = '+';

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(entrance);
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int qSize = queue.size();
            
            for (int n = 0 ; n < qSize ; n++) {
                
                int[] curr = queue.pollFirst();
                int currY = curr[0];
                int currX = curr[1];

                for (int i = 0 ; i < 4 ; i++) {

                    int nextY = currY + dy[i];
                    int nextX = currX + dx[i];

                    if (nextY < 0 || nextY >= mazeY || nextX < 0 || nextX >= mazeX) {
                        continue;
                    }
                    if (maze[nextY][nextX] == '+') {
                        continue;
                    }

                    if (nextY == 0 || nextY == mazeY - 1 || nextX == 0 || nextX == mazeX - 1) {
                        return steps;
                    }
                    maze[nextY][nextX] = '+';
                    queue.addLast(new int[] { nextY, nextX });
                }
            }
        }

        return -1;
    }
}