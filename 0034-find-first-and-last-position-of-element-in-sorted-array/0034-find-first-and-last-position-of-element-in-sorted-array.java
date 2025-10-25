// Leetcode : 34
class Solution {
    public int[] searchRange(int[] nums, int target) {        
        //return standardApproach(nums, target);        
        return binarySearchApproach(nums, target);        
    }
    
    // Saturday, October 25, 2025 10:49:18 AM
    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int[] binarySearchApproach(int[] nums, int target) {       
        int first = lowerBound(nums,target);
        int last = upperBound(nums,target)-1;  //<--

        // Check for valid result 
        if(first==nums.length || nums[first]!=target){
            return new int[]{-1,-1};
        }       
        return new int[]{first,last};
    } 

    public int lowerBound(int[] nums, int target){
        int left=0,right=nums.length;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){  //<--
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int upperBound(int[] nums, int target){
        int left=0,right=nums.length;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<=target){  //<--
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
    // Wednesday, April 23, 2025 7:01:04 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int[] standardApproach(int[] nums, int target) {        
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