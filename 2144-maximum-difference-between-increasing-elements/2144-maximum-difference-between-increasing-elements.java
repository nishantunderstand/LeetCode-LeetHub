// LeetCode 2016

class Solution {
    public int maximumDifference(int[] nums) {
        int len = nums.length;
        // int max = Integer.MIN_VALUE; // 
        int max = -1; 

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[j]>nums[i]){
                    int csum = nums[j]-nums[i];
                    max = Math.max(max,csum);
                }
            }
        }
        return max;
    }
}