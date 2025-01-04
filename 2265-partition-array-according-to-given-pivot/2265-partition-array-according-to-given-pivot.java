class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        return twoPointer(nums,pivot);
    }
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