// Leetcode : 62
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] rowArr:dp){
            Arrays.fill(rowArr,-1);
        }
        HashMap<String,Integer> memo = new HashMap<>(); //<--
        //return recSol(0,0,m,n);
        //return backtracking(0,0,m,n);
        //return dpTopDownMatrix(m,n,dp);
        //return dpTopDownMatrixMOD(m,n,dp);
        //return dpTopDownFlatten(m,n,dp);
        //return dpBottomUpMatrix(m,n);
        //return dpSpace(m,n); Pending
        //return prefixSum(m,n); Pending
        //return combinatorics(m,n); Pending
        //return dpBottomUpStriver(m-1,n-1,dp);
        //return dpMemo(m-1,n-1,dp);
        return dpHashMemo(m,n,memo); // 1 Based Indexing
        //return dpHashMemo(m-1,n-1,memo); // 0 Based Indexing
    }

    public int dpHashMemo(int m,int n,HashMap<String,Integer> memo){
        if(m<0 || n<0 ) return 0;
        //if(m==0 && n==0) return 1; // <-- 0 Based Indexing
        if(m==1 && n==1) return 1; // <-- 1 Based Indexing 
        String state = m +"-"+n; // Why - To make a Unique Key Signature
        if(memo.containsKey(state)) return memo.get(state); //<--
        int left = dpHashMemo(m-1,n,memo);
        int up = dpHashMemo(m,n-1,memo);
        memo.put(state,left+up);
        return left+up; //<--
    }
    
    // 0-Based Indexing
    public int dpMemo(int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int left = dpMemo(i,j-1,dp);
        int up = dpMemo(i-1,j,dp);
        dp[i][j] = left+up;
        return dp[i][j];  
    }

    public int dpBottomUpStriver(int i,int j,int[][]dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=dpBottomUpStriver(i-1,j,dp)+dpBottomUpStriver(i,j-1,dp);
        return dp[i][j];
    }

    // Thursday, January 9, 2025 6:58:03 PM
    // Time Complexity:O(m*n) | Space Complexity:O(m*n)
    public int dpBottomUpMatrix(int m,int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    // Thursday, January 9, 2025 6:57:54 PM
    // Time Complexity:O(m*n) | Space Complexity:O(m*n)
    public int dpTopDownFlatten(int m, int n, int[][] dp) {
    for (int i = 0; i < m * n; i++) {
        int row = i / n; // Calculate row index
        int col = i % n; // Calculate column index
        
        // Base case for first row or first column
        if (row == 0 || col == 0) {
            dp[row][col] = 1;
        } else {
            dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
        }
    }
    return dp[m - 1][n - 1]; // Return the bottom-right corner value
}

    // Time Complexity:O(m*n) | Space Complexity:O(m*n))
    public int dpTopDownMatrixMOD(int m,int n,int[][] dp){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }


    // Thursday, January 9, 2025 6:43:27 PM
    // Time Complexity:O(m*n) | Space Complexity:O(m*n))
    public int dpTopDownMatrix(int m,int n,int[][] dp){
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int j=0;j<n;j++) dp[0][j]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // Thursday, January 9, 2025 6:37:01 PM
    // Time Complexity:O2^m+n) | Space Complexity:O(m+n)
    public int backtracking(int sr,int sc,int dr,int dc){
        if(sr<0 || sc<0) return 0;         
        if(sr>=dr ||sc>=dc) return 0;
        if(sr==dr-1 && sc==dc-1) return 1;

        int down = backtracking(sr+1,sc,dr,dc);
        int right = backtracking(sr,sc+1,dr,dc);
        return down+right;    
    }   

    // Thursday, January 9, 2025 6:26:57 PM
    // Time Complexity:O(2^m+n) | Space Complexity:O(m+n)
    public int recSol(int i,int j,int m,int n){
        if(i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        return recSol(i+1,j,m,n) + recSol(i,j+1,m,n);
    }
}