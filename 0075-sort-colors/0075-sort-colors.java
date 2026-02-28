// Leetcode : 75
class Solution {
    public void sortColors(int[] nums) {
        dutchNationalFlag(nums);
    }

    // Monday, April 28, 2025 8:49:08 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    // Two Way Partition
    
    // Unstable Sort  //<--
    // Relative Order is not maintained  //<--
    // Look at the Naming Convenation
    public void dutchNationalFlag(int[] nums) {
        int i = 0;                 // next position for 0
        int j = 0;                 // current pointer (scanner)
        int k = nums.length - 1;   // next position for 2
        while (j <= k) {  //<--
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;  //<--
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, j, k); // <-- 
                k--;  //<--
            }
        }
    }

    // Time Complexity:O(1) | Space Complexity:O(1)
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}