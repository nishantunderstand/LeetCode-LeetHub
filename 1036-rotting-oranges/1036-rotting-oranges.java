// Leetcode : 994 
/**
MultiSource BFS 
Direction 4 Direction
*/

class Solution {
    public class Pair{
        int i;
        int j;
        int t;

        public Pair(int i,int j,int t){
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }

    public int orangesRotting(int[][] grid) {    
        int rows = grid.length;        
        int cols = grid[0].length;

        if(grid==null) return 0;
        if(rows==0) return 0;
        
        Queue<Pair> que = new LinkedList<>();
        int freshCnt=0;
        int totalTime=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    que.offer(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    freshCnt++;
                }
            }
        }

        if(freshCnt==0) return 0; //<--
        
        int[] DR = {-1,1,0,0};
        int[] DY = {0,0,-1,1};
        
        while(!que.isEmpty()){
            Pair current = que.poll();
            totalTime = current.t;

            for(int d=0;d<4;d++){
                int nx = DR[d]+current.i;
                int ny = DY[d]+current.j;

                if(isValid(nx,ny,grid)){
                    grid[nx][ny]=2;
                    que.offer(new Pair(nx,ny,current.t+1));
                }                
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return totalTime;
    } 
    
    public boolean isValid(int nx,int ny,int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        return nx>=0 && nx<rows && ny>=0 && ny<cols && grid[nx][ny]==1;
    }   
}