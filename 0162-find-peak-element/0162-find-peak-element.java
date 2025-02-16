// Leetcode : 162
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
        //return binarySearch(nums);
        return bruteForceSearch(nums);
    }


    public int bruteForceSearch(int[] nums) {
        int n = nums.length;
        int len = n;
        if (nums == null || n == 0) {
            return 0;
        }
        if(len==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        
        for(int i=1;i<len-1;i++){
            if(nums[i-1]<nums[i] && nums[i]>nums[i+1]){
                return i;
            }
        }
        return -1;        
    }

    public int binarySearch(int[] nums) {
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