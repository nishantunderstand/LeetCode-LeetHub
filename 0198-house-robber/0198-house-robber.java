// Leetcode : 198
class Solution {
    //private HashMap<Integer,Integer> memo; //<--
    private HashMap<String,Integer> memo; //<--
    int[] nums;

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp,-1);

        //return backtracking(nums,nums.length-1);
        //return dpTopDown(nums,dp,len-1); 
        //return dpBottomUp(nums); 
        //return dpSpace(); //Pending
        //return prefixApproach(); //Pending
        
        memo = new HashMap<>();
        return dpHashMemo(nums, nums.length-1);
    }

    public int dpHashMemo(int[] nums, int n){
        if(n<0) return 0;
        if(n==0) return nums[0];
        String state = n + "-";
        if(memo.containsKey(state)) return memo.get(state);
        
        int dont = dpHashMemo(nums,n-1);
        int take = nums[n] + dpHashMemo(nums,n-2);
        int result = Math.max(dont,take);
        
        memo.put(state,result);
        return result;
    }
    
    /**
    // Without String 
    public int dpHashMemo(int[] nums, int n){
        if(n<0) return 0;
        if(n==0) return nums[0];
        // String state = n + "-"; //NO NEED
        if(memo.containsKey(n)) return memo.get(n);
        int dont = dpHashMemo(nums,n-1);
        int take = nums[n] + dpHashMemo(nums,n-2);
        int result = Math.max(dont,take);
        memo.put(n,result);
        return result;
    }
    */

    //PENDING 
    public int dpSpace(int[] nums) {
        int len = nums.length;        
        if(len==0) return 0;
        if(len==1) return nums[0];
        return 0;        
    }

    // Thursday, January 9, 2025 10:31:58 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int dpBottomUp(int[] nums) {
        int len = nums.length;        
        if(len==0) return 0;
        if(len==1) return nums[0];

        //int[] dp = new int[len+1]; // Working Fine 
        int[] dp = new int[len]; // Working Fine
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