// Leetcode : 2161
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        return twoPointer(nums,pivot);  
    }
    
    // Should we Apply Dutch National Flag ? NO, As it is Unstable Sort
        
    // Saturday, January 4, 2025 9:14:55 PM 
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int[] twoPointer(int[] nums, int pivot) {
        int len=nums.length;
        int[] res=new int[len];
        int idx=0;
        for(int i=0;i<len;i++){
            if(nums[i]<pivot){
                res[idx++]=nums[i];
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]==pivot){
                res[idx++]=nums[i];
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]>pivot){
                res[idx++]=nums[i];
            }
        }
        return res;
    }
}