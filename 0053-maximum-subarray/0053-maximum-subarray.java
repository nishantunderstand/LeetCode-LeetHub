// Leetcode : 53
class Solution {
    public int maxSubArray(int[] nums) {
        //return bruteForce(nums); 
        return kadaneAlgorithm(nums);
        //return prefixSum(nums); 
        //return carryForward(nums);
        //return slidingWindow(nums); // Failed
    }

    // Tuesday, December 17, 2024 10:46:30 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int kadaneAlgorithm(int[] nums) {
        int maxSum = Integer.MIN_VALUE; //<--
        int csum = 0;
        for (int i = 0; i < nums.length; i++) {
            csum += nums[i];
            maxSum = Math.max(csum,maxSum);
            if(csum<0)csum=0;
        }
        return maxSum;
    }

    // Friday, March 21, 2025 6:34:11 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private int carryForward(int[] nums) {
        int n = nums.length;    
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
            if(sum<0) sum=0; // Reset Sum
        }
        return maxSum;
    }

    // Failed
    private int slidingWindowFailedNegative(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int windowStart = 0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];
            maxSum = Math.max(maxSum,windowSum);
            // This is where the sliding window approach fails: 
            // We don't handle negative contributions properly.
        }
        return maxSum;
    }

    // Friday, March 21, 2025 6:33:50 PM
    // Time Complexity:O(n^2) | Space Complexity:O(n)
    private int prefixSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];        
        // Out of Place - Prefix Sum
        for(int i=0;i<n;i++){ //<---
            prefix[i+1]=prefix[i] + nums[i];
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                maxSum = Math.max(maxSum, prefix[j+1]-prefix[i]);
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
