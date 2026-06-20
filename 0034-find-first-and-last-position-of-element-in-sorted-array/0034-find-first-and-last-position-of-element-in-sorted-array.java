// Saturday, June 6, 2026 12:45:02 AM
// TC : O(n nlogn) | SC : O(1 n)
// LeetCode : 34
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = findLB(nums,target);
        
        if(lb==nums.length || nums[lb]!=target){
            return new int[]{-1,-1};
        }
        int ub = findUB(nums,target);
        return new int[]{lb,ub-1};
    }

    private int findLB(int[] nums, int k){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low);
            if(nums[mid]<k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private int findUB(int[] nums, int k){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low);
            if(nums[mid]<=k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}