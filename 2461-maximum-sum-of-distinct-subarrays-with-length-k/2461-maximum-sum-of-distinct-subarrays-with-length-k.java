// LeetCode : 2461
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int windowStart = 0;
        long windowSum = 0;
        long maxSum = 0;
        Set<Integer> seen = new HashSet<>();
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            // Check For Duplicate & Increase windowStart
            while(seen.contains(nums[windowEnd])){
                windowSum -= nums[windowStart];
                seen.remove(nums[windowStart]);
                windowStart++;                
            }

            // Add 
            windowSum += nums[windowEnd];
            seen.add(nums[windowEnd]);

            if(windowEnd-windowStart+1==k){                
                maxSum = Math.max(maxSum,windowSum);            
                
                // Slide the window                
                windowSum -= nums[windowStart];
                seen.remove(nums[windowStart]);
                windowStart++;
                
            }
        }
        return maxSum;
    }   
}

