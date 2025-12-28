// Leetcode : 724
class Solution {
    public int pivotIndex(int[] nums) {
        //return modifiedRunningSum(nums);
        //return runningSum(nums);
        //return runningSum2(nums);
        //return prefixSumApproach(nums);
        return presuffixSumApproach(nums);
        
    }

    private int presuffixSumApproach(int[] nums){
        int n = nums.length;
        
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] + nums[i];
        }

        for(int i=0;i<n;i++){
            int leftSum = (i==0)?0:prefix[i-1];
            int rightSum = (i==n-1)?0:suffix[i+1];
            if(leftSum == rightSum) return i;
        }
        return -1;
    }

    private int prefixSumApproach(int[] nums){
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        for(int i=0;i<n;i++){
            int leftSum = (i==0)?0:prefix[i-1];
            int rightSum = prefix[n-1] - prefix[i]; 
            if(leftSum == rightSum) return i;
        }
        return -1;
    }

    private int runningSum2(int[] nums) {
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }       
        int leftSum = 0;
        for(int i=0;i<nums.length;i++){
            int rightSum =  totalSum - leftSum - nums[i];
            if(leftSum==rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

   

    // Monday, March 17, 2025 9:11:46 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private int runningSum(int[] nums) {
        int totalSum = 0;
        for(int num:nums){
            totalSum += num;
        }
        int leftSum = 0;
        // Iterate with Index
        for(int i=0;i<nums.length;i++){
            totalSum -= nums[i];
            if(leftSum==totalSum) return i;  //<--
            leftSum += nums[i];
        }
        return -1;
    }

    // Monday, March 17, 2025 9:11:46 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int modifiedRunningSum(int[] nums) {
        int n = nums.length;
        if(nums==null||n==0){
            return -1;
        }
        int totalSum = 0;
        int leftSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        // Here we are increasing lsum and also decreading totalSum
        // Alternative could be lsum == totalSum-lsum-nums[i], only add nums[i] to lsum
        for(int i=0;i<n;i++){
            if(leftSum+nums[i] == totalSum){
                return i;
            }
            leftSum+=nums[i];
            totalSum-=nums[i];
        }
        return -1;
    }
}