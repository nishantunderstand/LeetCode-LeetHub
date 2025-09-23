// LeetCode 2461

// Friday, February 21, 2025 7:15:32 PM
// Time Complexity:O(n) | Space Complexity:O(k)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long windowSum = 0;
        long maxSum = 0;
        int windowStart = 0;
        Set<Integer> hs = new HashSet<>(); //<--
        // HashSet<Integer> hs = new HashSet<>(); //<-- Less Flexible
        for(int windowEnd=0;windowEnd<len;windowEnd++){
            // If duplicate is found, shrink the window
            while(hs.contains(nums[windowEnd])){
                hs.remove(nums[windowStart]);
                windowSum -= nums[windowStart];
                windowStart++;
            }

            // Add the new element to the set and sum            
            hs.add(nums[windowEnd]);
            windowSum+=nums[windowEnd];
            
            // Check if we have a valid window of size `k`
            if(windowEnd-windowStart+1==k){ //<-- b - a + 1
                maxSum = Math.max(maxSum,windowSum);

                // Move the window forward
                hs.remove(nums[windowStart]);
                // Remove Old & Increment                
                windowSum -= nums[windowStart];                
                windowStart++;
            }
        }
        return maxSum;
    }
}