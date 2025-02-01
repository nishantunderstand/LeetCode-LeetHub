class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for(int[] rowArr : dp){
            Arrays.fill(rowArr,-1);
        }
        int cnt = 0;
        return dpTopDown(obstacleGrid,row-1,col-1,dp,cnt); //Pending
        //return dpBottomUp(,dp); //Pending
        //return dpSpace(); //Pending
        //return prefixApproach(); //Pending
    }
    public int dpTopDown(int[][] mat,int dr,int dc,int[][]dp,int cnt) {
        if(dr<0 || dc< 0 || mat[dr][dc]==1) return 0;        
        if(dr==0 && dc==0) return 1;
        if(dp[dr][dc]!=-1) return dp[dr][dc];
        int up = dpTopDown(mat,dr-1,dc,dp,cnt+1);
        int left = dpTopDown(mat,dr,dc-1,dp,cnt+1);
        dp[dr][dc]=up+left;
        return dp[dr][dc];
    }
}