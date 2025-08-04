class Solution {

    Deque<int[]> queue = new ArrayDeque<>();

    public int maximalSquare(char[][] matrix) {

        int maxX = matrix[0].length;
        int maxY = matrix.length;
        int size = 0;

        for(int currY = 0 ; currY < maxY ; currY++) {
            for(int currX = 0 ; currX < maxX ; currX++) {
                if(matrix[currY][currX] == '1') {
                    queue.add(new int[]{currY, currX});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.peekFirst();
            if(isSquare(matrix, curr[1], curr[0], size, maxX, maxY)) {
                size++;
            } else {
                queue.removeFirst();
            }
        }

        return (int) Math.pow(Math.max(size - 1, 0), 2);
    }

    private boolean isSquare(char[][] matrix, int x, int y, int size, int maxX, int maxY) {
        if(x + size - 1 >= maxX || y + size - 1 >= maxY) {
            
            return false;
        }

        for(int currY = y ; currY < y + size ; currY++) {
            for(int currX = x ; currX < x + size ; currX++) {
                if(matrix[currY][currX] == '0') {
                    return false;
                }
            }
        }

        return true;
    }
}