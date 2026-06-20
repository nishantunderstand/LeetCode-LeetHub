// Saturday, April 11, 2026 11:08:42 PM
// LeetCode : 209
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // We need to find a subArray whose sum is greater than target , But length should be miinimum   

        int windowStart=0, windowSum=0, minLen=Integer.MAX_VALUE;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];
            while(windowSum>=target){
                minLen = Math.min(minLen, windowEnd-windowStart+1);
                windowSum -= nums[windowStart++];
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}