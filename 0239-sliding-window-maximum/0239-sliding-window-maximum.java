// LeetCode : 239
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        int windowStart=0;

        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            max = Math.max(max,nums[windowEnd]);

            if(windowEnd>=k=1){
                max = Math.max(max,nums[windowEnd]);

            }
        }
    }
}