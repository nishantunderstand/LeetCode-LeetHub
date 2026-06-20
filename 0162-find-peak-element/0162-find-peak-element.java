class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<high){ //<--
            int mid = low + (high-low)/2;
            if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }else{
                high = mid;
            }
        }        
        return low;
    }
}
// Saturday, June 6, 2026 12:25:47 AM
// TC : O(nlogn) | SC : O(1)
// LeetCode : 162