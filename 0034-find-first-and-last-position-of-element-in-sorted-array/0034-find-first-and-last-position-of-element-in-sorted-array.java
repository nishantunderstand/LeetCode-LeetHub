// Leetcode : 34
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        
        // Finding 1st
        int first = -1;
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==target){
                first = mid;
                hi = mid-1;
            }else if(nums[mid]>target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        // findingLast
        int last = -1;
        lo = 0;
        hi = nums.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==target){
                last = mid;
                lo = mid+1;
            }else if(nums[mid]>target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return new int[]{first,last};        
        
    }
}