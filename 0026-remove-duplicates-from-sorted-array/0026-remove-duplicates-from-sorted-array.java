// Leetcode : 26
class Solution {
    public int removeDuplicates(int[] nums) {
        return inplaceApproach(nums);
            
    }

    // Wednesday, April 23, 2025 6:32:02 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int inplaceApproach(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int idx = 1;  //<--
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {                
                nums[idx] = nums[i];
                idx++  //<--
            }
        }
        return idx;
    }
}