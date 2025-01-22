/**
 * Array Size
 * <0,0,
    How these code is different from Remove Duplicate in Array.
    Here we are using modified version of RemoveDuplicate in Array
 */

class Solution {
    public int removeDuplicates(int[] nums) {
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