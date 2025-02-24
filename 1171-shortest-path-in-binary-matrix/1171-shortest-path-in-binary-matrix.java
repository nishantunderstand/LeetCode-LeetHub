// Leetcode : 1091
/**
Graph Question Cue : 8 directionally Connected
BFS 
*/

class Solution {
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
    int len = Integer.MAX_VALUE;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid[0][0]==1 || grid[rows-1][cols-1]==1) return -1;
        
       

        //backtrackingApproach(grid,0,0);
        boolean[][] vis = new boolean[rows][cols];
        //return len==Integer.MAX_VALUE?-1:len;
        return bfsApproach(grid);
    }
    public void backtrackingApproach(int[][] grid,int i,int j,boolean[][] vis){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols) return;
        if(grid[i][j]==1) return;
        if(vis[i][j]) return;

        vis[i][j]=true;
        backtrackingApproach(grid,i,j,vis);
        backtrackingApproach(grid,i,j,vis);
        backtrackingApproach(grid,i,j,vis);
        backtrackingApproach(grid,i,j,vis);
        backtrackingApproach(grid,i,j,vis);
        vis[i][j]=false;

    }

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

