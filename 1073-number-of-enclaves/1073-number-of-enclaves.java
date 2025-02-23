// Leetcode : 1020
class Solution {
    public int numEnclaves(int[][] grid) {     
        return numEnclavesWITHOUTVIS(grid);
        //return numEnclavesWithVis(grid);
    }



    public int numEnclavesWITHOUTVIS(int[][] grid) {
        // This is Modified Version Of Surrounded Region
        // Mark Cell that are connected to first row/Col or last row/col to Zero

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if((i==0 || i==rows-1 || j==0 || j==cols-1) && grid[i][j]==1){
                    dfs(grid,i,j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;        
    }

    public void dfs(int[][] grid,int i,int j){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols) return;
        if(grid[i][j]!=1) return;
        
        grid[i][j]=0; //<--
        
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}