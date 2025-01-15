class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null || text2==null || text1.length()==0 || text2.length()==0) return 0;

        int[][] dp = new int [text1.length()+1][text2.length()+1];
        for(int[] rowArr : dp ){
            Arrays.fill(rowArr,-1);
        }        
        //return recursive_LCS(text1,text2,text1.length(),text2.length());
        //return LCSDPTopDown(text1,text2,text1.length(),text2.length(),dp);
        return LCSDPBottomUp(text1,text2);
    }
    public int LCSDPBottomUp(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int [m+1][n+1];

        /** 
        // i=0, Then Empty Subset or 0 (IDK)
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        */
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // Matches
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }
                // Not Matches
                else{
                    int first = dp[i-1][j];
                    int second = dp[i][j-1];
                    dp[i][j]=Math.max(first,second);
                }
            }
        }
        return dp[m][n];
    }

    // Wednesday, January 15, 2025 6:34:11 PM
    // Time Complexity:O(m*n) | Space Complexity:O(m*n)
    public int LCSDPTopDown(String s1, String s2,int m,int n,int[][] dp) {
        if(m==0 || n==0) return 0;
        
        if (dp[m][n]!=-1) return dp[m][n];
        // String Match 
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            dp[m][n] = 1 + LCSDPTopDown(s1,s2,m-1,n-1,dp);
            return dp[m][n];
        }
        // String Not-Match
        int first = LCSDPTopDown(s1,s2,m,n-1,dp);
        int second = LCSDPTopDown(s1,s2,m-1,n,dp);
        dp[m][n] = Math.max(first,second);

        return dp[m][n];
    }



    // Wednesday, January 15, 2025 6:33:34 PM
    // Time Complexity:O(2^m*2^n) | Space Complexity:O(m+n)
    public int recursive_LCS(String s1, String s2,int m,int n) {
        if(m==0 || n==0) return 0;
        
        // String Match 
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1 + recursive_LCS(s1,s2,m-1,n-1);
        }
        // String Not-Match
        int first = recursive_LCS(s1,s2,m,n-1);
        int second = recursive_LCS(s1,s2,m-1,n);
        return Math.max(first,second);
    }

}