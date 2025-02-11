// LeetCode 746
class Solution {    
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int cost1 = dpMemo(cost,dp,n-1);
        int cost2 = dpMemo(cost,dp,n-2);
        return Math.min(cost1,cost2);
    }

    public int dpMemo(int[] cost,int[] dp,int n){
        if(n<0) return 0;
        if(n==0 || n==1) return cost[n];

        if(dp[n]!=-1) return dp[n];
        
        dp[n]=cost[n] + Math.min(dpMemo(cost,dp,n-1), dpMemo(cost,dp,n-2));
        return dp[n];
    }
}