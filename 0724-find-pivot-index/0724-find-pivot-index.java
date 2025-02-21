class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(nums==null||n==0){
            return -1;
        }
        int tsum = 0;
        int lsum = 0;
        for(int i=0;i<n;i++){
            tsum+=nums[i];
        }
        // Here we are increasing lsum and also decreading tsum
        // Alternative could be lsum == tsum-lsum-nums[i], only add nums[i] to lsum
        for(int i=0;i<n;i++){
            if(lsum+nums[i] == tsum){
                return i;
            }
            lsum+=nums[i];
            tsum-=nums[i];
        }
        return -1;
    }
}