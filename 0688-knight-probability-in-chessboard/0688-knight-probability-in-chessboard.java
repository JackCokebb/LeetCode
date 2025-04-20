class Solution {

    Deque<int[]> queue = new ArrayDeque<>();
    int[] dRow = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dCol = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
    double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k + 1];
        return recursive(n, k, row, column);
    }

    public double recursive(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }

        if (k == 0) { 
            return 1;
        }

        if (dp[row][column][k] != 0) {
            return dp[row][column][k];
        }

        double result = 0;

        for (int i = 0 ; i < 8 ; i++) {
            result += 0.125 * recursive(n, k - 1, row + dRow[i], column + dCol[i]);
        }

        dp[row][column][k] = result;
        return result;
    }
}