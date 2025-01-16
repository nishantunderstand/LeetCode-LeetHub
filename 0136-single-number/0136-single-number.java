class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        if(nums==null||n==0){
            return -1;
        }
        int curr = nums[0];
        for(int i=1;i<n;i++){
            curr = curr^nums[i];
        }
        return curr;
    }
}