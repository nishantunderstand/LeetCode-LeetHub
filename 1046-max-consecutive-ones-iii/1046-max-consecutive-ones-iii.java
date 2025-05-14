// Leetcode : 1004
class Solution {
    public int longestOnes(int[] nums, int k) {            
        return slidingWindowApproach(nums,k);       
    }

    // Wednesday, May 14, 2025 11:44:13 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int slidingWindowApproach(int[] nums, int k) {        
        int zeroCnt=0,windowStart = 0,maxLen=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            if(nums[windowEnd]==0) zeroCnt++;

            while(zeroCnt>k){
                if(nums[windowStart]==0)zeroCnt--;                
                windowStart++;  //<--
                // Always move windowStart forward
            }
            maxLen = Math.max(windowEnd-windowStart+1,maxLen);
        }
        return maxLen;       
    }
}