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
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}