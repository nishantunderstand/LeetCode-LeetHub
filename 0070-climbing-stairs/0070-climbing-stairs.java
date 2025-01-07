class Solution {
    public int climbStairs(int n) {
        //return recursive(n);
        return dpBottomUp(n);
    }

    public int dpBottomUp(int n) {
        if(n<0) return 0;
        int[] dp = new int[n+1];
        dp[0]=1; // Tricky Point
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];            
        }
        return dp[n];
    }    


    // Tuesday, January 7, 2025 7:06:13 PM
    // Time Complexity:O(2^n) | Space Complexity:O(1)
    // TLE
    public int recursive(int n) {
        if(n<0) return 0;
        if(n==0) return 1;
        return recursive(n-1) + recursive(n-2);
    }


}