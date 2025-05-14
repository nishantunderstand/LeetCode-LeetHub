// Leetcode : 283
class Solution {
    int[] nums;

    public void moveZeroes(int[] nums) {
        //basedOnDutchNationalFlag(nums);
        //bySwapNotRelativeOrder(nums);
        //nonZerotoStart(nums);  //<--
        
        this.nums = nums;
        byDutchNationFlag();
    }

    // 
    public void byDutchNationFlag() {
        int i = 0, j = 0, len = nums.length;
        while (i < len && j < len) {
            if (nums[i] == 0)
                i++;
            else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }

    // Wednesday, May 14, 2025 4:07:51 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private void nonZerotoStart(int[] nums) {
        int nonZeroLoc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, nonZeroLoc++);
            }
        }
    }

    // Saturday, February 15, 2025 12:41:47 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    // Relative Order is Maintained
    public void basedOnDutchNationalFlag(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (i < len && j < len) {
            if (nums[i] == 0) {
                i++;
            } else {
                swap(nums, i, j);
                j++;
                i++;
            }
        }
    }

    // Time Complexity:O(1) | Space Complexity:O(1)
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Correct But Not Required , Question Required is Different 
    // Out Of Place Approach, Relative Order is Not Maintained
    private void bySwapNotRelativeOrder(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
    }
}

// I cannot swap with End Element, As it is Unknown
// However i can use Dutch National Flag Algorithm, Know and Unknow Region Concept
/**
0 1 0 3 12
*/

// Related Leetcode : 75 