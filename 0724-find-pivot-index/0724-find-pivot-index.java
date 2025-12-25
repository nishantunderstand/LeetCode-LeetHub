// Leetcode : 724
class Solution {
    public int pivotIndex(int[] nums) {
        return modifiedRunningSum(nums);
        //return runningSum(nums);
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