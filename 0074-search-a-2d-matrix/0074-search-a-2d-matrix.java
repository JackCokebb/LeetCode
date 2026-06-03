class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (m == 1) {
            return search(matrix, 0, n, target);
        }
        
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == target) return true;
            if (matrix[i][0] < target) continue;
            return search(matrix, i - 1, n, target);
        }
        
        return search(matrix, m - 1, n, target);
    }

    private boolean search(int[][] matrix, int m, int nSize, int target) {
        for (int i = 0; i < nSize; i++) {
            if (matrix[m][i] == target) {
                return true;
            }
        }

        return false;
    }
}