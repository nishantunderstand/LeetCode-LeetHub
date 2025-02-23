// Leetcode : 55

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach =  0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i>maxReach) return false; // How did you reach ??
            maxReach = Math.max(maxReach,i+nums[i]);
        }
        return true; // Reached the end
    }
}