class Solution {
    public HashMap<String,Integer> memo;
    final int OBSTACLE=1;
    final int EMPTY=0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for(int[] rowArr : dp){
            Arrays.fill(rowArr,-1);
        }
        
        //return dpTopDown(obstacleGrid,row-1,col-1,dp); //Pending
        //return dpBottomUp(,dp); //Pending
        //return dpSpace(); //Pending
        //return prefixApproach(); //Pending

        memo = new HashMap<>();
        return dpHashMemo(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1);
    }
    // Convert to 0-Based Indexing
    public int dpHashMemo(int[][] grid,int r,int c){
        if(r<0 || c<0 || grid[r][c]==OBSTACLE) return 0;
        if(r==0 && c==0 && grid[r][c]!=OBSTACLE) return 1;
        String state = r + "-"+ c;
        if(memo.containsKey(state)) return memo.get(state);
        int top = dpHashMemo(grid,r-1,c);
        int left = dpHashMemo(grid,r,c-1);
        memo.put(state,top+left);
        return top+left;
    }

    // Saturday, February 1, 2025 8:59:55 PM
    // Time Complexity:O(m*n) | Space Complexity:O(m*n)
    public int dpTopDown(int[][] mat,int dr,int dc,int[][]dp) {
        if(dr<0 || dc< 0 || mat[dr][dc]==1) return 0;        
        if(dr==0 && dc==0) return 1;
        if(dp[dr][dc]!=-1) return dp[dr][dc];
        int up = dpTopDown(mat,dr-1,dc,dp);
        int left = dpTopDown(mat,dr,dc-1,dp);
        dp[dr][dc]=up+left;
        return dp[dr][dc];
    }
}