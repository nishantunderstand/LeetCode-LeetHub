// LeetCode : 643
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];

            if(windowEnd>=k-1){ // Need to Understand On Dry Run 
                maxSum = Math.max(maxSum,windowSum);

                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return (double)maxSum/k;
    }
}


// Window Move Logic Depend upon Fixed Size k, It would not matter