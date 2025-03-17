class Solution {
    public int search(int[] nums, int target) {        
        return iterativeBinarySearch(nums,target);
    }

    public int iterativeBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
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
}