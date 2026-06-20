class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        int maxLen = 1;

        // 1,2,3,4 , 100,200
        int currLen = 1;
        for(int i=1;i<nums.length;i++){            
            // Skip Duplicates
            
            if(nums[i]==nums[i-1]){
                continue;
            }
 
            if(nums[i]==nums[i-1]+1){
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }else{
                currLen = 1;
            }
        }
        return maxLen;
    }
}