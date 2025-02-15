class Solution {
    public int minPathSum(int[][] grid) {
        //return backtracking(grid,grid.length-1,grid[0].length-1);
        //return backtrackingNEW(grid,grid.length-1,grid[0].length-1);
        
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] rowArr : dp ){
            Arrays.fill(rowArr,-1);
        }
        return dpTopDown(grid,grid.length-1,grid[0].length-1,dp);
        //return dpBottomUp(grid);
    }

    public int dpBottomUp(int[][] grid,int i,int j,int[][] dp){
        return 0;
    }

    // Monday, January 13, 2025 7:40:35 PM
    // Time Complexity:O(m*n) | Space Complexity:O(m*n)
    public int dpTopDown(int[][] grid,int i,int j,int[][] dp){
        if(i==0 && j==0) return grid[0][0]; //<--
        if(i<0 || j <0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];

        int up =  dpTopDown(grid,i-1,j,dp);
        int left = dpTopDown(grid,i,j-1,dp);
        dp[i][j] = grid[i][j] + Math.min(up,left);
        return dp[i][j]; // Whyn't dp[0][0] ??
    }

    // If you want to find Minimium , Then you have to return a very large value.
    // TLE 
    // Monday, January 13, 2025 7:19:45 PM
    // Time Complexity:O(2^n) | Space Complexity:O(n)
    public int backtrackingNEW(int[][] grid,int i,int j){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j <0) return Integer.MAX_VALUE;
        
        int up =  backtrackingNEW(grid,i-1,j);
        int left = backtrackingNEW(grid,i,j-1);
        return grid[i][j]+Math.min(up,left);
    }

    // What's wrong with my Code
    public int backtracking(int[][] grid,int i,int j){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j <0) return Integer.MAX_VALUE;
        
        int up = grid[i][j] + backtracking(grid,i-1,j);
        int left = grid[i][j]+ backtracking(grid,i,j-1);
        return Math.min(up,left);
    }
}