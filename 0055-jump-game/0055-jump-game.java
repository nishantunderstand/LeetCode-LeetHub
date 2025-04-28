// Leetcode : 55
class Solution {
    public boolean canJump(int[] nums) {
        //return striverApproach(nums);
        return striverApproachMOD(nums);
    }

    public boolean striverApproachMOD(int[] nums) {
        int maxReach =  0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i>maxReach) return false; // How did you reach ??
            maxReach = Math.max(maxReach,i+nums[i]);
            if(maxReach>=len-1) return true; // Optimization
        }
        return true; // Reached the end
    }

    // Sunday, February 23, 2025 10:30:30 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public boolean striverApproach(int[] nums) {
        int maxReach =  0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i>maxReach) return false; // How did you reach ??
            maxReach = Math.max(maxReach,i+nums[i]);
        }
        return true; // Reached the end
    }
}