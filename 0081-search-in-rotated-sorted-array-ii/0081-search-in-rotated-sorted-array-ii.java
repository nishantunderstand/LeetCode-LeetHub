// Saturday, June 6, 2026 2:30:22 PM
// TC : O(logn) | SC : O(1)
// LeetCode : 81
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<= high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return true;
            }

            // left = right = mid 
            if(nums[mid]==nums[low] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }

            // left Sorted              
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target < nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // right Sorted
            else{
                if(nums[mid]< target && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}