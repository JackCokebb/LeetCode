class Solution {
    public int closedIsland(int[][] grid) {
        int gridXLen = grid[0].length;
        int gridYLen = grid.length;
        int count = 0;
        
        for(int i = 0 ; i < gridYLen ; i++){
            for(int j = 0 ; j < gridXLen ; j++){
                if(grid[i][j] == 0){
                    if(isClosed(grid, j, i)){
                        count++;
                        System.out.println("x: " + j + " y: " + i);
                    }
                        
                }
            }
        }
        
        return count;
        
    }
    private boolean isClosed(int[][] grid, int currX, int currY){
        int[] dirX = new int[]{0, 0, -1, 1};
        int[] dirY = new int[]{-1, 1, 0, 0};
        int gridXLen = grid[0].length;
        int gridYLen = grid.length;
        boolean result = true;
        
        for(int i = 0 ; i < 4 ; i++){
            int searchingX = currX + dirX[i];
            int searchingY = currY + dirY[i];
            
            if((searchingX < 0 || searchingX >= gridXLen) 
               || (searchingY < 0 || searchingY >= gridYLen) ) return false;
            
            if(grid[searchingY][searchingX] == 0){
                grid[searchingY][searchingX] = -1;
                result = result && isClosed(grid, searchingX, searchingY);
                if(!result) grid[searchingY][searchingX] = 0;
            } 
        }
        
        return result;
    }
}