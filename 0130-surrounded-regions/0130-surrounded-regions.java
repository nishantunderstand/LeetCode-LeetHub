// DFS Question , Visited Matrix
// Leetcode : 130

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        
        if(rows==0) return;

        // First Column and Last => Column ROW INDEX
        for(int i=0;i<rows;i++){
            
            if(!vis[i][0] && board[i][0]=='O') dfs(board,vis,i,0); // First Col
            if(!vis[i][cols-1] && board[i][cols-1]=='O') dfs(board,vis,i,cols-1); // Last Col            
        }        

        // First and Last Row => COLUMN INDEX
        for(int j=0;j<cols;j++){
            if(!vis[0][j] && board[0][j]=='O') dfs(board,vis,0,j); // Firs Row
            if(!vis[rows-1][j] && board[rows-1][j]=='O') dfs(board,vis,rows-1,j);   // Last Row                      
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        
    }

    public void dfs(char[][] board,boolean[][] vis ,int i,int j){
        int rows = board.length;
        int cols = board[0].length;

        if(i<0 || j<0 || i>=rows || j>= cols) return;
        if(vis[i][j]) return;
        if(board[i][j] != 'O') return;

        vis[i][j]=true; //<--

        dfs(board,vis,i+1,j);
        dfs(board,vis,i-1,j);
        dfs(board,vis,i,j+1);
        dfs(board,vis,i,j-1);        
    }
    
}   