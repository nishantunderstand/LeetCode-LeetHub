class Solution {
    public int search(int[] nums, int target) {
        return binarySearchApproach(nums,target);
        //return linearSearchApproach(nums,target);
    }

    // Thursday, March 20, 2025 6:01:27 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int binarySearchApproach(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            //left Sorted
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target <= nums[mid]){
                    high =mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            // right Sorted
            else{
                if(nums[mid]<=target && target <=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return-1;
    }


    // Thursday, March 20, 2025 6:01:11 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int linearSearchApproach(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}