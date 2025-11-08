// Leetcode : 724
class Solution {
    public int pivotIndex(int[] nums) {
        return modifiedRunningSum(nums);
        //return runningSum(nums);
    }

    // Monday, March 17, 2025 9:11:46 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private int runningSum(int[] nums) {
        int tSum = 0;
        for(int num:nums){
            tSum += num;
        }
        int lSum = 0;
        // Iterate with Index
        for(int i=0;i<nums.length;i++){
            tSum -= nums[i];
            if(lSum==tSum) return i;  //<--
            lSum += nums[i];
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
        int tsum = 0;
        int lsum = 0;
        for(int i=0;i<n;i++){
            tsum+=nums[i];
        }
        // Here we are increasing lsum and also decreading tsum
        // Alternative could be lsum == tsum-lsum-nums[i], only add nums[i] to lsum
        for(int i=0;i<n;i++){
            if(lsum+nums[i] == tsum){
                return i;
            }
            lsum+=nums[i];
            tsum-=nums[i];
        }
        return -1;
    }
}