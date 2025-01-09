class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp,-1);

        //return backtracking(nums,nums.length-1);
        return dpTopDown(nums,dp,len-1); //Pending
        //return dpBottomUp(,dp); //Pending
        //return dpSpace(); //Pending
        //return prefixApproach(); //Pending
    }
    
    public int dpTopDown(int[] nums,int[] dp,int idx) {
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int take = nums[idx] +  dpTopDown(nums,dp,idx-2);
        int dont = 0 + dpTopDown(nums,dp,idx-1);
        dp[idx] = Math.max(take,dont);
        return dp[idx];
    }


    // TLE 
    // Thursday, January 9, 2025 10:15:57 PM
    // Time Complexity:O(2^n) | Space Complexity:O(n)
    public int backtracking(int[] nums,int idx) {
        if(idx<0) return 0;
        int take = nums[idx]+ backtracking(nums,idx-2);
        int dont = 0+ backtracking(nums,idx-1);
        return Math.max(take,dont);
    }
}