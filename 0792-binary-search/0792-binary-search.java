class Solution {
    public int search(int[] nums, int target) {        
        //return iterativeBinarySearch(nums,target);
        return defaultMethod(nums,target);
    }

    // Monday, March 17, 2025 9:15:02 AM
    // Time Complexity:O(logn) | Space Complexity:O(1)
    public int iterativeBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2; //<--
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    // Monday, March 17, 2025 9:15:02 AM
    // Time Complexity:O(logn) | Space Complexity:O(1)
    public int defaultMethod(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i < 0 ? -1 : i;

    }
}