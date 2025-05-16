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
    public void dutchNationalFlag(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (i <= k) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                i++;
                j++;  //<--
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, k);
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