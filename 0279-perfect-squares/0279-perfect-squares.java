// Leetcode : 279
class Solution {
    public int numSquares(int n) {
        //return recursive(n);
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        HashMap<Integer,Integer> memo = new HashMap<>();
        //return dpTopDown(n,dp);
        return dpHashMemo(n,memo);
    }

    // Monday, February 24, 2025 7:18:58 PM
    // Time Complexity:O(n*sqrt(n)) | Space Complexity:O(n)
    public int dpHashMemo(int n,HashMap<Integer,Integer> memo){
        if(n<=3) return n; 
        
        if(memo.containsKey(n)) return memo.get(n);
        int ways = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            ways = Math.min(ways,1 + dpHashMemo(n-(i*i),memo));
        }
        memo.put(n,ways);
        return ways;
    }


    // Tuesday, January 7, 2025 7:44:46 PM
    // Time Complexity:O(n*sqrt(n)) | Space Complexity:O(n)
    public int dpTopDown(int n,int[] dp) {
        if(n<=3) return n;
        if(dp[n]!=-1) return dp[n];
        int cnt=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            cnt=Math.min(cnt,1+dpTopDown(n-i*i,dp));
        }
        dp[n]=cnt;
        return dp[n];
    }    

    // Tuesday, January 7, 2025 7:38:43 PM
    // Time Complexity:O(2^n) | Space Complexity:O(1)
    public int recursive(int n) {
        if(n<=3) return n;
        int cnt=Integer.MAX_VALUE;
        //int cnt=0; Why Wrong ?
        for(int i=1;i*i<=n;i++){
            cnt = Math.min(cnt,1+recursive(n-i*i));
        }
        return cnt;
    }
}