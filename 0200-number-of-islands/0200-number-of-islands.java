public class Solution {

    private int yLen;
    private int xLen;

    public int numIslands(char[][] grid) {
        int count = 0;
        yLen = grid.length;
        if (yLen == 0)
            return 0;
        xLen = grid[0].length;
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= yLen || j >= xLen || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}