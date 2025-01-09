class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp,-1);

        //return backtracking(nums,nums.length-1);
        //return dpTopDown(nums,dp,len-1); 
        return dpBottomUp(nums); //Pending
        //return dpSpace(); //Pending
        //return prefixApproach(); //Pending
    }
    
    public int dpBottomUp(int[] nums) {
        int len = nums.length;
        
        if(len==0) return 0;
        if(len==1) return nums[0];

        int[] dp = new int[len+1]; // Whyn't len+1
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        //dp[0]=Math.max(0,nums[0]); // Only Postive Value Given
        dp[1]=Math.max(nums[0],nums[1]);
        //dp[1]=Math.max(dp[0],nums[1]); // Test Them
        for(int i=2;i<len;i++){
            int take = nums[i]+dp[i-2];
            int dont = 0 + dp[i-1];
            dp[i]=Math.max(take,dont);
        }
        return dp[len-1];
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