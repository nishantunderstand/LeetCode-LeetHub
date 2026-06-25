// Thursday, June 25, 2026 7:58:36 PM
// TC : O(4^L m*n) | SC : O(m*n * L)
// LeetCode : 79
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && dfs(board,word,i,j,0,m,n,vis)) return true;                    
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i,int j, int idx, int m, int n , boolean[][] vis){

        // Guard Case
        if(i<0 || j<0 || i>=m || j>=n) return false;
        
        // Check Already Visited
        if(vis[i][j]) return false;
        // Check Charactre Mistmatch
        if(board[i][j]!=word.charAt(idx)) return false;


        // Base Case
        if(idx==word.length()-1) return true;
        
        // Do
        vis[i][j]=true;

        // Recurse
        boolean found = 
            dfs(board,word, i+1,j,idx+1,m,n,vis) ||
            dfs(board,word, i-1,j,idx+1,m,n,vis) ||
            dfs(board,word, i,j+1,idx+1,m,n,vis) ||
            dfs(board,word, i,j-1,idx+1,m,n,vis);
            
        // Undo
        vis[i][j] = false;

        return found;
    }
}
