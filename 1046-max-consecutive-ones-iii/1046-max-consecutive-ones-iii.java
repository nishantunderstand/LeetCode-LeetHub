// Leetcode : 1004
class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCnt=0,windowStart = 0,maxLen=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            if(nums[windowEnd]==0) zeroCnt++;

            while(zeroCnt>k){
                if(nums[windowStart]==0){
                    zeroCnt--;                
                }
                windowStart++;  //<--
                // Always move windowStart forward
            }
            maxLen = Math.max(windowEnd-windowStart+1,maxLen);
        }
        return maxLen;       
    }
}