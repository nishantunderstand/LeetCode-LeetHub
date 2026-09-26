// LeetCode : 1493
class Solution {
    // Saturday, September 26, 2026 11:47:21 PM    
    // TC : O(n) | SC : O(1)
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int left = 0;
        int zeroCount = 0;    
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0) zeroCount++;
            while(zeroCount>1){
                if(nums[left]==0){
                    zeroCount--;                    
                    // left++; // Wrong Place
                }
                left++; //<--
            }
            maxLen = Math.max(maxLen, right-left); //<--
        }   
        return maxLen;
    }
}