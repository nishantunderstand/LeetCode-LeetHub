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
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
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


    // WITHOUT VIS ARRAY
    public void dfs(char[][] grid,int dr,int dc){
        int rows = grid.length;
        int cols = grid[0].length;
        if(dr<0 || dr>=rows || dc<0 || dc>=cols) return;
        if(grid[dr][dc]=='0') return;

        grid[dr][dc]='0';

        dfs(grid,dr+1,dc);
        dfs(grid,dr,dc+1);
        dfs(grid,dr-1,dc);
        dfs(grid,dr,dc-1);
    }
    
    // WITH VIS ARRAY
    public void dfs(char[][] grid,boolean[][] vis,int dr,int dc){
        int rows = grid.length;
        int cols = grid[0].length;
        if(dr<0 || dr>=rows || dc<0 || dc>=cols) return;
        if(grid[dr][dc]=='0' || vis[dr][dc]) return;

        vis[dr][dc]=true;

        dfs(grid,vis,dr+1,dc);
        dfs(grid,vis,dr,dc+1);
        dfs(grid,vis,dr-1,dc);
        dfs(grid,vis,dr,dc-1);
    }
}