// Leetcode : 70
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        HashMap<Integer,Integer> memo = new HashMap<>();

        //return recursive(n);
        //return dpBottomUp(n);
        //return dpMemo(n,dp);
        //return dpMemoMOD(n,dp);
        return dpHashMap(n,memo);
    }

    // Monday, February 24, 2025 7:04:01 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int dpHashMap(int n,HashMap<Integer,Integer> memo){
        if(n==0) return 1;
        if(n<0) return 0;
        if(memo.containsKey(n)) return memo.get(n);
        int ways = dpHashMap(n-1,memo) + dpHashMap(n-2,memo);
        memo.put(n,ways);
        return ways;
    }


    // Time Complexity:O(n) | Space Complexity:O(n)
     public int dpMemoMOD(int n,int[] dp) {
        if(n<0) return 0;
        if(n==0||n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int oneStep = dpMemoMOD(n-1,dp);
        int twoStep = dpMemoMOD(n-2,dp);
        dp[n] = oneStep + twoStep;
        return dp[n];
    }

    public int dpMemo(int n,int[] dp) {
        if(n<0) return 0;  //<-- Better Sential Value
        if(n==1||n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n] = dpMemo(n-1,dp) + dpMemo(n-2,dp);
        return dp[n];
    }

    // Tuesday, January 7, 2025 7:12:32 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int dpBottomUp(int n) {
        if(n<0) return 0;
        int[] dp = new int[n+1];
        dp[0]=1; //<--
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