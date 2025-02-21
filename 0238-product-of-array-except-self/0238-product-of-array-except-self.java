class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0]=1;
        // Start From 2 Location From Start
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }

        suffix[nums.length-1]=1;
        // Start from 2 Location From end
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}