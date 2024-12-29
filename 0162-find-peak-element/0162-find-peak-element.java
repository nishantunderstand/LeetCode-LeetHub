/**
 * Postive Array
 * Negative Array
 * Mixed
 * 
 * nums[i] != nums[i + 1] for all valid i. - What does this means ?
 * 
 * Strictly Increasing
 * Strictly Decreasing
 * Combination of them
 * 
 * Edge Case
 * 0 , n-1
 * Why are handling it Seperately ?
 * Whyn't Handle it like the rest of it ?
 * 
 * 
 * I don't need to think in the direction of lo and hi, Instead i need to think
 * in something else direction.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        return bruteForce(nums);
    }

    public int bruteForce(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}