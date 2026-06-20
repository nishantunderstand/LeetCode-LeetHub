// Leetcode : 154
class Solution {
    public int findMin(int[] nums) {
        //return binarySearchOptimized(nums);
        return binarySearch(nums);
    }

    // IDK How to Sovle it ???
    private int binarySearch(int[] nums) {
        int lo =0, hi = nums.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]<nums[hi]) hi = mid;
            else if(nums[mid]>nums[hi]) lo = mid+1;
            else hi--;
        }
        return nums[lo];
    }

    public int binarySearchOptimized(int[] nums) {
        int lo = 0,hi = nums.length-1;
        int minVal = Integer.MAX_VALUE;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;            
            // Cannot decide, shrink both ends
            if(nums[lo]==nums[mid] && nums[mid]==nums[hi]){
                minVal = Math.min(minVal,nums[lo]);
                lo++;
                hi--;
            }
            // left Sorted
            else if(nums[lo]<=nums[mid]){
                minVal = Math.min(minVal,nums[lo]);
                lo = mid+1;
            }
            // right Sorted
            else{
                minVal = Math.min(minVal,nums[mid]);
                hi = mid-1;
            }
        }
        return minVal;
    }
}