// LeetCode 200

class Solution {    
    public int numIslands(char[][] grid) {
       //return withvis(grid);
       return withOutvis(grid);
    }

    // Thursday, February 13, 2025 2:57:22 PM
    // Time Complexity:O(V+E) | Space Complexity:O(V)    
    public int withOutvis(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int cnt = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){                    
                    cnt++;
                    //dfs(grid,i,j);
                    //dfsDIR(grid,i,j);
                    dfs2DDIR(grid,i,j);
                }
            }
        }
        return cnt;
    }
    // WITHOUT VIS ARRAY
    public void dfs(char[][] grid,int dr,int dc){
        int rows = grid.length;
        int cols = grid[0].length;
        if(dr<0 || dr>=rows || dc<0 || dc>=cols) return;
        if(grid[dr][dc]=='0') return;

        grid[dr][dc]='0'; // Marking it 

        dfs(grid,dr+1,dc);
        dfs(grid,dr,dc+1);
        dfs(grid,dr-1,dc);
        dfs(grid,dr,dc-1);
    }

     // WITHOUT VIS ARRAY + Direction Array
    public void dfsDIR(char[][] grid,int dr,int dc){
        int rows = grid.length;
        int cols = grid[0].length;
        if(dr<0 || dr>=rows || dc<0 || dc>=cols) return;
        if(grid[dr][dc]=='0') return;

        grid[dr][dc]='0'; // Marking it 
        int[] DR = {-1,1,0,0};
        int[] DY = {0,0,-1,1};

        for(int i=0;i<4;i++){
            dfsDIR(grid,dr+DR[i],dc+DY[i]);
        }    
    }

    public void dfs2DDIR(char[][] grid,int dr,int dc){
        int rows = grid.length;
        int cols = grid[0].length;
        if(dr<0 || dr>=rows || dc<0 || dc>=cols) return;
        if(grid[dr][dc]=='0') return;

        grid[dr][dc]='0'; // Marking it 
        int[][] DIR = {
            {-1, 0}, // UP
            {1, 0}, // DOWN
            {0, -1}, // LEFT
            {0, 1} // RIGHT
        };

        for(int[] d : DIR){
            int newRow = dr + d[0];
            int newCol = dc + d[1];
            dfs(grid,newRow,newCol);
        }    
    }





    // Thursday, February 13, 2025 2:57:22 PM
    // Time Complexity:O(V+E) | Space Complexity:O(V)
    public int withvis(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !vis[i][j]){                    
                    cnt++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return cnt;
    }
    // WITH VIS ARRAY
    public void dfs(char[][] grid,boolean[][] vis,int dr,int dc){
        int rows = grid.length;
        int cols = grid[0].length;
        if(dr<0 || dr>=rows || dc<0 || dc>=cols) return;
        if(grid[dr][dc]=='0' || vis[dr][dc]) return;

        vis[dr][dc]=true; // Marking as Visited

        dfs(grid,vis,dr+1,dc);
        dfs(grid,vis,dr,dc+1);
        dfs(grid,vis,dr-1,dc);
        dfs(grid,vis,dr,dc-1);
    }
}