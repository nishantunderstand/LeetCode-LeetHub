// Leetcode : 153
class Solution {
    public int findMin(int[] nums) {
        //return findMinBS(nums);
        //return binarySearchLike33(nums);
        return binarySearch(nums);
    }

    private int binarySearch(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    private int binarySearchLike33(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int minVal = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // Already Sorted
            if (nums[lo] <= nums[hi]) {
                minVal = Math.min(minVal, nums[lo]);
                return minVal;  //<--
            }

            // left Sorted
            if (nums[lo] <= nums[mid]) {
                minVal = Math.min(minVal, nums[lo]);  //<--
                lo = mid + 1; //<-- 
            } else { // Right half Sorted 
                minVal = Math.min(minVal, nums[mid]);  //<--
                hi = mid - 1; //<--
            }
        }
        return minVal;  //<--
    }

    public int findMinBS(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

}