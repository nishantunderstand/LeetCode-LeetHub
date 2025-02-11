class Solution {
    public int searchInsert(int[] nums, int target) {
        // return linearSearch(nums,target);
        return binarySearch(nums, target);
    }

    // Tuesday, February 11, 2025 11:50:34 AM
    // Time Complexity:O(logn) | Space Complexity:O(1)
    public int binarySearch(int[] nums, int target) {
        int n = nums.length;
        // if(nums==null||n<=0){return 0;} Sometimes it may give TLE, Don't use Blindlly
        int lo = 0;
        int hi = n - 1;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // Tuesday, February 11, 2025 11:50:30 AM
    // Time Complexity:O(n) | Space Complexity:O(1)
    // Linear Search Approach
    public int linearSearch(int[] nums, int target) {
        int n = nums.length;
        if (nums == null || n <= 0) { // target == 0 is UnImportant
            return 0;
        }
        for (int i = 0; i < n; i++) {
            // Match Found
            if (nums[i] == target) {
                return i;
            }
            // Closed Match
            if (nums[i] > target) {
                return i;
            }
        }
        // If greater than all element
        return n;
    }

}