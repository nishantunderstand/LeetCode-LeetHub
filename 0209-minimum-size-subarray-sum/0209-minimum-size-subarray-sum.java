class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE; //<--
        int csum = 0;
        int start = 0;
        for(int end=0;end<nums.length;end++){
            csum += nums[end];
            while(csum>=target){
                minLen = Math.min(end-start+1,minLen);
                csum -= nums[start];
                start++;
            }                            
        }      
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}
// LeetCode : 209
