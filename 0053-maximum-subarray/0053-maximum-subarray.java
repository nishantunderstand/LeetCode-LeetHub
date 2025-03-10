// Leetcode : 53
class Solution {
    public int maxSubArray(int[] nums) {
        //return bruteForce(nums); 
        return kadaneAlgorithm(nums);
        //return prefixSum(nums); 
        //return carryForward(nums);

    }

    // Tuesday, December 17, 2024 10:46:30 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int kadaneAlgorithm(int[] nums) {
        int maxSum = Integer.MIN_VALUE; //<--
        int csum = 0;
        for (int i = 0; i < nums.length; i++) {
            csum += nums[i];
            maxSum = Math.max(csum,maxSum);
            if(csum<0){
                csum=0;
            }
        }
        return maxSum;
    }
    
    // Tuesday, December 17, 2024 10:46:34 PM
    // Time Complexity:O(n^2) | Space Complexity:O(1)
    // TLE
    public int bruteForce(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
    }
}
