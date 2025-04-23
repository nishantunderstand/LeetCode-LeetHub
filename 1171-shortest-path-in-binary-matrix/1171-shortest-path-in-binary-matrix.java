// Leetcode : 1091
/**
Graph Question Cue : 8 directionally Connected
BFS 
*/

class Solution {
    int len = Integer.MAX_VALUE;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid[0][0]==1 || grid[rows-1][cols-1]==1) return -1;
        
        boolean[][] vis = new boolean[rows][cols];
        //backtrackingApproach(grid,0,0,vis,1); //<--
        //return len==Integer.MAX_VALUE?-1:len;

        return bfsApproach(grid);
    }

    // Monday, February 24, 2025 6:42:54 PM
    // Time Complexity:O(8^n) | Space Complexity:O(n)
    public void backtrackingApproach(int[][] grid,int i,int j,boolean[][] vis,int currLen){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols ||grid[i][j]==1||vis[i][j] ) return;
        
        if(currLen>=len) return; //<-- Pruning Earlier

        if(i==rows-1 && j==cols-1){
            len = Math.min(len,currLen);
            return;
        }
        // if(currLen>=len) return; //<-- Prunning Later        
        // if(grid[i][j]==1) return;  //<-- Prunning Later
        // if(vis[i][j]) return;  //<-- Prunning Later


        vis[i][j]=true;
        backtrackingApproach(grid, i - 1, j - 1, vis, currLen + 1); // Top-left
        backtrackingApproach(grid, i - 1, j, vis, currLen + 1);     // Top
        backtrackingApproach(grid, i - 1, j + 1, vis, currLen + 1); // Top-right
        backtrackingApproach(grid, i, j - 1, vis, currLen + 1);     // Left
        backtrackingApproach(grid, i, j + 1, vis, currLen + 1);     // Right
        backtrackingApproach(grid, i + 1, j - 1, vis, currLen + 1); // Bottom-left
        backtrackingApproach(grid, i + 1, j, vis, currLen + 1);     // Bottom
        backtrackingApproach(grid, i + 1, j + 1, vis, currLen + 1); // Bottom-right

        vis[i][j]=false;
    }



    private class Pair{
        int i;
        int j;
        int len;

        public Pair(int i,int j,int len){
            this.i = i;
            this.j = j;
            this.len=len;
        }
    }

    

    // Monday, February 24, 2025 6:43:34 PM
    // Time Complexity:O(m*n) | Space Complexity:O(m*n)
    public int bfsApproach(int[][] grid) {
        int sr = 0,sc = 0;
        int rows = grid.length, cols = grid[0].length;

        if(grid[0][0]==1 || grid[rows-1][cols-1]==1) return -1;
        
        boolean[][] vis = new boolean[rows][cols];
        
        // Queue<Pair> que = new ArrayDeque<>();
        Queue<Pair> que = new LinkedList<>();// Safer
        que.offer(new Pair(0,0,1)); //<--
        vis[0][0]=true;

        int[] DR = {-1,1,0,0, -1,-1,1,1};
        int[] DC = {0,0,-1,1, -1,1,1,-1};

        while(!que.isEmpty()){
            Pair curr = que.poll();
            int r = curr.i;
            int c = curr.j;
            int len = curr.len;
            if(r==rows-1 && c == cols-1) return len;

            for(int d=0;d<8;d++){
                int nr = r+DR[d];
                int nc = c+DC[d];
                if(isValid(nr,nc,grid,vis)){                    
                    vis[nr][nc]=true;
                    que.offer(new Pair(nr,nc,len+1));                        
                }
            }

        }
        return -1;

    }

    public boolean isValid(int nx,int ny,int[][] grid,boolean[][] vis){
        int rows = grid.length;
        int cols = grid[0].length;
        return nx>=0 && nx<rows && ny>=0 && ny<cols && grid[nx][ny]==0 && !vis[nx][ny];
    }
}

