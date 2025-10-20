class Solution {
    public void setZeroes(int[][] matrix) {
        int yLen = matrix.length;
        int xLen = matrix[0].length;

        Set<Integer> yCoors = new HashSet<>();
        Set<Integer> xCoors = new HashSet<>();


        for(int i = 0 ; i < yLen ; i++) {
            for(int j = 0 ; j < xLen ; j++) {
                if(matrix[i][j] == 0) {
                    yCoors.add(i);
                    xCoors.add(j);
                }
            }           
        }

        for(int y : yCoors) {
            Arrays.fill(matrix[y], 0);
        }

        for(int x : xCoors) {
            for(int i = 0 ; i < yLen ; i++) {
                matrix[i][x] = 0;
            }
        }
    }
}